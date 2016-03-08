package com.example.raj.testst;

import java.util.ArrayList;

/**
 * Created by raj on 2/1/16.
 */
public class Config {
    public static final String DATA_URL = "http://myandroiddevelopment.esy.es/stationary.php";
    public static String uname;
    public static String uemail;

    //JSON TAGS
    public static final String TAG_IMAGE_URL = "pimage";
    public static final String TAG_NAME = "pname";
    public static final String TAG_DESC = "pdesc";
    public static final String TAG_PRICE = "price";

    public static final String OID_URL = "http://myandroiddevelopment.esy.es/ono.php";
    public static final String ST_URL = "http://myandroiddevelopment.esy.es/stationary.php";
    public static final String MARKER_URL = "http://myandroiddevelopment.esy.es/marker.php";
    public static final String PACKING_URL = "http://myandroiddevelopment.esy.es/packing.php";
    public static final String CLOTH_URL = "http://myandroiddevelopment.esy.es/cloth.php";
    public static final String ORDER_URL = "http://myandroiddevelopment.esy.es/order.php";


    public static final String LOGIN_URL ="http://myandroiddevelopment.esy.es/login.php";
    public static final String Register_URL ="http://myandroiddevelopment.esy.es/Register.php";
    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_MOBILE = "mobile";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

    public static ArrayList<Stationary> cartlist = new ArrayList<Stationary>();

}
