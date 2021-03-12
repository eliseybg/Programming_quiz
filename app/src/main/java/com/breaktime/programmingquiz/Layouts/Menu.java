package com.breaktime.programmingquiz.Layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.breaktime.programmingquiz.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openHelloWorldQuiz(View view) {
        Intent intent = new Intent(this, DetectLanguage.class);
        startActivity(intent);
    }

    public void openITSlangQuiz(View view) {
        Intent intent = new Intent(this, DetectLanguage.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openAboutUs(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void openShootingInFeet(View view) {
        Intent intent = new Intent(this, ShootingInFoot.class);
        startActivity(intent);
    }

    public void openFindMatch(View view) {
        Intent intent = new Intent(this, FindMatch.class);
        startActivity(intent);
    }
}