package pl.pwsztar.mobilerestaurant.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;

import static android.content.Context.MODE_PRIVATE;

public class UserModelUtils {
    private static final String USER_KEY = "USER_MODEL";
    public static LoginResponse getUser(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USER_KEY, "");
        return gson.fromJson(json, LoginResponse.class);
    }

    public static void saveUser(Context context, LoginResponse response) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(response);
        prefsEditor.putString(USER_KEY, json);
        prefsEditor.apply();
    }

    public static void removeUser(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.remove(USER_KEY);
        prefsEditor.apply();
    }
}
