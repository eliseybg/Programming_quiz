package com.breaktime.programmingquiz.Layouts;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.breaktime.programmingquiz.CreateQuestions.ShootingInFootQuestions;
import com.breaktime.programmingquiz.R;
import com.breaktime.programmingquiz.SaveAndLoadSettings;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ShootingInFoot extends AppCompatActivity {
    private TextView helloWorldView;
    private TextView right;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ArrayList<ShootingInFootQuestions.Node> list;
    private ShootingInFootQuestions questionList;
    private int current = 0;
    private int rightAnswers;
    private Dialog dialog;
    private int[] arrange;
    private int amountOfQuestions;
    private boolean sound, timer;
    private MediaPlayer mp;

    private ProgressBar progressBar;
    private ObjectAnimator progressAnimator;
    private int time = 20;
    Timer timerRun = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shooting_in_foot);
        getSettings();
        setView();
        questionList = new ShootingInFootQuestions(this);
        startQuiz(amountOfQuestions);
    }

    private void getSettings() {
        SaveAndLoadSettings settings = new SaveAndLoadSettings(getSharedPreferences(SaveAndLoadSettings.FILE, MODE_PRIVATE));
        if (settings.getSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_QUESTIONS)) {
            arrange = new int[]{28, 26, 23};
            amountOfQuestions = 30;
        } else {
            arrange = new int[]{10, 9, 7};
            amountOfQuestions = 10;
        }
        timer = settings.getSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_TIMER);
        sound = !settings.getSettings(SaveAndLoadSettings.SOUND);
    }

    private void anim() {
        progressBar.setMax(1000);
        progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 1000, 0);
        progressAnimator.setDuration(time * 1000);
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        progressAnimator.start();

        timerRun.cancel();
        timerRun = new Timer();
        timerRun.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    enterAnswer(null);
                });
            }
        }, time * 1000);
    }

    private void startQuiz(int size) {
        current = 0;
        rightAnswers = 0;
        list = questionList.getQuestionList(size);
        setQuestion();
    }

    private void setView() {
        right = findViewById(R.id.right);
        helloWorldView = findViewById(R.id.hello_world);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        dialog = new Dialog(this);
        progressBar = findViewById(R.id.progressBar);
        if (!timer)
            progressBar.setVisibility(View.INVISIBLE);
    }

    void setQuestion() {
        right.setText(list.get(current).rightAnswer + "");
        helloWorldView.setText(list.get(current).helloWorldText);
        helloWorldView.setTextSize(list.get(current).helloWorldTextSize);
        button1.setText(list.get(current).answers[0]);
        button2.setText(list.get(current).answers[1]);
        button3.setText(list.get(current).answers[2]);
        button4.setText(list.get(current).answers[3]);
        if (timer) {
            anim();
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void enterAnswer(View view) {
        if (progressAnimator != null)
            progressAnimator.setDuration(0);
        if (current >= list.size())
            return;
        int answer = -1;
        switch (view.getId()) {
            case R.id.button1:
                answer = 0;
                break;
            case R.id.button2:
                answer = 1;
                break;
            case R.id.button3:
                answer = 2;
                break;
            case R.id.button4:
                answer = 3;
                break;
        }
        if (list.get(current).rightAnswer == answer)
            rightAnswers++;
        current++;

        if (current >= list.size()) {
            if (rightAnswers >= arrange[0]) {
                openGoldWinDialog();
                return;
            }
            if (rightAnswers >= arrange[1] && rightAnswers < arrange[0]) {
                openSilverWinDialog();
                return;
            }

            if (rightAnswers >= arrange[2] && rightAnswers < arrange[1]) {
                openBronzeWinDialog();
                return;
            }
            openLoseDialog();
            return;
        }
        setQuestion();
    }

    private void openGoldWinDialog() {
        if (sound) {
            mp = MediaPlayer.create(this, R.raw.right_answer);
            mp.start();
        }
        setDialog(R.layout.gold_win_layout_dialog);
    }

    private void openSilverWinDialog() {
        if (sound) {
            mp = MediaPlayer.create(this, R.raw.right_answer);
            mp.start();
        }
        setDialog(R.layout.silver_win_layout_dialog);
    }

    private void openBronzeWinDialog() {
        if (sound) {
            mp = MediaPlayer.create(this, R.raw.right_answer);
            mp.start();
        }
        setDialog(R.layout.bronze_win_layout_dialog);
    }

    private void openLoseDialog() {
        if (sound) {
            mp = MediaPlayer.create(this, R.raw.wrong_answer);
            mp.start();
        }
        setDialog(R.layout.lose_layout_dialog);
    }

    private void setDialog(int id) {
        dialog.setContentView(id);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView res = dialog.findViewById(R.id.res);
        res.setText("Correct answers: " + rightAnswers);
        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);
        imageViewClose.setOnClickListener(v -> {
            finish();
            dialog.cancel();
        });

        Button btnAgain = dialog.findViewById(R.id.btnAgain);
        btnAgain.setOnClickListener(v -> {
            startQuiz(amountOfQuestions);
            dialog.cancel();
        });

        dialog.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                finish();
                dialog.cancel();
            }
            return false;
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timerRun.cancel();
    }
}