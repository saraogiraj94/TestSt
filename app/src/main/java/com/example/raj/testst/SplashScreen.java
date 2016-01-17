package com.example.raj.testst;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends Activity{
    private SessionManager session;
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();
        Thread timerThread = new Thread(){
            public void run(){
                try{

                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    session = new SessionManager(getApplicationContext());

                    // SQLite database handler
                    // db = new SQLiteHandler(getApplicationContext());

                    // Check if user is already logged in or not
                    if (session.isLoggedIn()) {
                        // User is already logged in. Take him to main activity
                        Intent intent = new Intent(SplashScreen.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent = new Intent(SplashScreen.this,
                                StartUp.class);
                        startActivity(intent);
                        finish();

                    }
                }
            }
        };
        timerThread.start();
        super.onCreate(savedInstanceState);



    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);

    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
