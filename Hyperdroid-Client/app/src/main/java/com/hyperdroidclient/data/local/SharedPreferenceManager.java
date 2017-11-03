package com.hyperdroidclient.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;

public class SharedPreferenceManager {
    private SharedPreferences settings;

    private static final String PREFS_NAME = "HyperdroidPrefs";
    private static final String PREFS_FULLNAME = "name";
    private static final String PREFS_EMAILID = "emailid";

    private static final String PREFS_ACCESS_TOKEN = "accessToken";
    private static final String PREFS_MAINPAGE = "mainpage";
    private static String PREFS_DEVICE_TOKEN = "devicetoken";


    public SharedPreferenceManager(Context mContext) {
        settings = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveName(String first_name) {
        settings.edit().putString(PREFS_FULLNAME, first_name).apply();
    }

    public void saveEmail(String last_name) {
        settings.edit().putString(PREFS_EMAILID, last_name).apply();
    }


    public void saveMainPage(int page) {
        settings.edit().putInt(PREFS_MAINPAGE, page).apply();
    }

    public void saveAccessToken(String accessToken) {
        settings.edit().putString(PREFS_ACCESS_TOKEN, accessToken).apply();
    }

    public String getAccessToken() {
        return settings.getString(PREFS_ACCESS_TOKEN, null);
    }


    public String getName() {
        return settings.getString(PREFS_FULLNAME, "");
    }

    public String getEmailId() {
        return settings.getString(PREFS_EMAILID, "");
    }


    public int getMainPage() {
        return settings.getInt(PREFS_MAINPAGE, 0);
    }

    public void saveDeviceToken(String token) {
        settings.edit().putString(PREFS_DEVICE_TOKEN, token).apply();
    }

    public String getDeviceToken() {
        return settings.getString(PREFS_DEVICE_TOKEN, null);
    }

    public void removeAccessToken() {
        settings.edit().remove(PREFS_ACCESS_TOKEN).apply();
    }

    public void removeMainPage() {
        settings.edit().remove(PREFS_MAINPAGE).apply();
    }

    public void removeAllToken() {
        settings.edit().clear().apply();
    }


}
