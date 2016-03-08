package com.example.raj.testst;

import android.content.pm.PackageInstaller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;

public class MyAccount extends AppCompatActivity {
    TextView n,e;
    SessionManager sessionManager;
    private SQLiteHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getApplicationContext());
        db=new SQLiteHandler(getApplicationContext());
        HashMap<String,String> user= db.getUserDetails();
        String name=user.get("name");
        String email=user.get("email");
        setContentView(R.layout.activity_my_account);
        n=(TextView)findViewById(R.id.myname);
        n.setText(name);
        e=(TextView)findViewById(R.id.myemail);
        e.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
