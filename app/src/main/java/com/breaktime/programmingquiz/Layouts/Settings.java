package com.breaktime.programmingquiz.Layouts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.breaktime.programmingquiz.Notifications.ShowNotifications;
import com.breaktime.programmingquiz.R;
import com.breaktime.programmingquiz.SaveAndLoadSettings;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Settings extends AppCompatActivity {
    private SaveAndLoadSettings saveAndLoadSettings;
    SwitchCompat switchAllQuestionsDetectLanguage, switchTimeForAnswerDetectLanguage,
            switchAllQuestionsFindMatch, switchTimeForAnswerFindMatch,
            switchAllQuestionsShootingInFoot, switchTimeForAnswerShootingInFoot,
            switchAllQuestionsITCommunication, switchTimeForAnswerITCommunication,
            switchNotificationSettings, switchSoundSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        saveAndLoadSettings = new SaveAndLoadSettings(getSharedPreferences(SaveAndLoadSettings.FILE, MODE_PRIVATE));
        setView();
        getSettings();
    }

    private void setView() {
        switchAllQuestionsDetectLanguage = findViewById(R.id.switchAllQuestionsDetectLanguage);
        switchTimeForAnswerDetectLanguage = findViewById(R.id.switchTimeForAnswerDetectLanguage);
        switchAllQuestionsFindMatch = findViewById(R.id.switchAllQuestionsFindMatch);
        switchTimeForAnswerFindMatch = findViewById(R.id.switchTimeForAnswerFindMatch);
        switchAllQuestionsShootingInFoot = findViewById(R.id.switchAllQuestionsShootingInFoot);
        switchTimeForAnswerShootingInFoot = findViewById(R.id.switchTimeForAnswerShootingInFoot);
//        switchAllQuestionsITCommunication = findViewById(R.id.switchAllQuestionsITCommunication);
//        switchTimeForAnswerITCommunication = findViewById(R.id.switchTimeForAnswerITCommunication);
        switchNotificationSettings = findViewById(R.id.switchNotificationSettings);
        switchSoundSettings = findViewById(R.id.switchSoundSettings);
    }

    private void getSettings() {
        switchAllQuestionsDetectLanguage.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.DETECT_LANGUAGE_QUESTIONS));
        switchTimeForAnswerDetectLanguage.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.DETECT_LANGUAGE_TIMER));
        switchAllQuestionsFindMatch.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.FIND_MATCH_QUESTIONS));
        switchTimeForAnswerFindMatch.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.FIND_MATCH_TIMER));
        switchAllQuestionsShootingInFoot.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_QUESTIONS));
        switchTimeForAnswerShootingInFoot.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_TIMER));
//        switchAllQuestionsITCommunication.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.IT_COMMUNICATION_QUESTIONS));
//        switchTimeForAnswerITCommunication.setChecked(saveAndLoadSettings.getSettings(SaveAndLoadSettings.IT_COMMUNICATION_TIMER));
        switchNotificationSettings.setChecked(!saveAndLoadSettings.getSettings(SaveAndLoadSettings.NOTIFICATIONS));
        switchSoundSettings.setChecked(!saveAndLoadSettings.getSettings(SaveAndLoadSettings.SOUND));
    }

    @Override
    public void onPause() {
        super.onPause();
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.DETECT_LANGUAGE_QUESTIONS, switchAllQuestionsDetectLanguage.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.DETECT_LANGUAGE_TIMER, switchTimeForAnswerDetectLanguage.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.FIND_MATCH_QUESTIONS, switchAllQuestionsFindMatch.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.FIND_MATCH_TIMER, switchTimeForAnswerFindMatch.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_QUESTIONS, switchAllQuestionsShootingInFoot.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.SHOOTING_IN_FOOT_TIMER, switchTimeForAnswerShootingInFoot.isChecked());
//        saveAndLoadSettings.setSettings(SaveAndLoadSettings.IT_COMMUNICATION_QUESTIONS, switchAllQuestionsITCommunication.isChecked());
//        saveAndLoadSettings.setSettings(SaveAndLoadSettings.IT_COMMUNICATION_TIMER, switchTimeForAnswerITCommunication.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.NOTIFICATIONS, !switchNotificationSettings.isChecked());
        saveAndLoadSettings.setSettings(SaveAndLoadSettings.SOUND, !switchSoundSettings.isChecked());
        if (!switchNotificationSettings.isChecked())
            timerNotifications();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void timerNotifications() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int delayInHour =  24;
        scheduler.scheduleAtFixedRate(new ShowNotifications(getApplicationContext(), getSystemService(NotificationManager.class)), delayInHour, 24, TimeUnit.HOURS);
    }
}