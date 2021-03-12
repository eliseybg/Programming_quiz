package com.breaktime.programmingquiz.Layouts;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.breaktime.programmingquiz.Notifications.ShowNotifications;
import com.breaktime.programmingquiz.R;
import com.breaktime.programmingquiz.SaveAndLoadSettings;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSettings();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(SplashScreenActivity.this, Menu.class);
            SplashScreenActivity.this.startActivity(mainIntent);
            SplashScreenActivity.this.finish();
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private void getSettings(){
        SaveAndLoadSettings saveAndLoadSettings = new SaveAndLoadSettings(getSharedPreferences(SaveAndLoadSettings.FILE, MODE_PRIVATE));
        if (!saveAndLoadSettings.getSettings(SaveAndLoadSettings.NOTIFICATIONS))
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