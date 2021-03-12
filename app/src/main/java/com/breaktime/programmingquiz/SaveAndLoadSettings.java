package com.breaktime.programmingquiz;

import android.content.SharedPreferences;

public class SaveAndLoadSettings{
    private final SharedPreferences settings;
    public static final String FILE = "Settings";
    public static final String DETECT_LANGUAGE_QUESTIONS = "detect language questions";
    public static final String DETECT_LANGUAGE_TIMER = "detect language timer";
    public static final String FIND_MATCH_QUESTIONS = "find match questions";
    public static final String FIND_MATCH_TIMER = "find match timer";
    public static final String SHOOTING_IN_FOOT_QUESTIONS = "shooting in foot questions";
    public static final String SHOOTING_IN_FOOT_TIMER = "shooting in foot timer";
    public static final String IT_COMMUNICATION_QUESTIONS = "it communication questions";
    public static final String IT_COMMUNICATION_TIMER = "it communication timer";
    public static final String NOTIFICATIONS = "is off notifications";
    public static final String SOUND = "is off sound";

    public SaveAndLoadSettings(SharedPreferences settings) {
        this.settings = settings;
    }

    public void setSettings(String type, boolean mode){
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putBoolean(type, mode);
        prefEditor.apply();
    }

    public boolean getSettings(String type){
        return settings.getBoolean(type, false);
    }

}
