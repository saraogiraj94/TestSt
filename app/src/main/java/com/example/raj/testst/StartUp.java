package com.example.raj.testst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartUp extends AppCompatActivity {

    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.sign);

    }

    public void c1(View view){
        Intent in = new Intent(this,Login.class);
        startActivity(in);
        finish();
    }

    public void c2(View view){
        Intent in = new Intent(this,Register.class);
        startActivity(in);
        finish();
    }

}
