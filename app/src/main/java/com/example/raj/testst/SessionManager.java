package com.example.raj.testst;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by raj on 16/1/16.
 */
public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidHiveLogin";
    private static final String U_NAME="User Name";
    private static final String U_EMAIL="User Name";
    String name;
    String email;
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }
    public void setData(String name,String email){
        this.name=name;
        this.email=email;
        editor.putString(U_NAME, name);
        editor.putString(U_EMAIL, email);
        editor.commit();
    }

    public String getuName(){
        return pref.getString(U_NAME,name);
    }
    public String getuEmail(){
        return  pref.getString(U_EMAIL,email);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
