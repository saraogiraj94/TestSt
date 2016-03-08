package com.example.raj.testst;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCart extends AppCompatActivity {
    ArrayList<Stationary> cart;
    String pname, qty, price, uid;
    static String oid;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    String arr;
    Button b1;
    private SQLiteHandler db;
    JSONObject jsonObject = new JSONObject();
    Stationary st;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        //String [] arr = new String[cart.size()]
        cart = Config.cartlist;
        b1 = (Button) findViewById(R.id.enquiry);

        if(cart.isEmpty()){
            b1.setEnabled(false);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Cart is empty kindly go to home page and shop?");
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            //Puting the value false for loggedin

                            //Starting login activity

                            Intent in = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(in);
                            finish();
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            //Showing the alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        //  cart=getIntent().getParcelableArrayListExtra("list");
        recyclerView = (RecyclerView) findViewById(R.id.res);
        // recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        arr = new String();
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CartListAdapter(getApplicationContext());

        for (int i = 0; i < cart.size(); i++) {
            st = cart.get(i);
            pname = st.getName();
            qty = st.getQty().toString();
            price = st.getPrice().toString();
            arr = (arr + st.getName() + " " + st.getDesc() + " " + st.getQty() + st.getPrice() + " \n ").toString();
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(null);
        db = new SQLiteHandler(getApplicationContext());
        HashMap<String, String> user = db.getUserDetails();
        uid = user.get("uid");

        //  Toast.makeT
        // ext(this,cart.toString(),Toast.LENGTH_LONG).show();


    }

    public void enquire(View view) {
        String tag_string_req = "req_register";
        final int[] flag = {1};
        oid = Oid();

       /* StringRequest strReq = new StringRequest(Request.Method.POST,
                Config.OID_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                        //Toast.makeText(getApplicationContext(),"Enquiry Succesfully Placed ",Toast.LENGTH_LONG).show();
                        //JSONObject jobj= new JSONObject(response);

                        oid=jObj.getString("oid");
                        Toast.makeText(getApplicationContext(),"Order id is "+oid,Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Error", Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("uid",uid);
                return params;
            }
        };
        Singleton.getInstance().addToRequestQueue(strReq, tag_string_req);


*/

        // Toast.makeText(this,arr.toString() +" ",Toast.LENGTH_LONG).show();
       /* HashMap<String, String> user = db.getUserDetails();
       /* uid = user.get("uid").toString();
        // for(i=1;i<cart.size();i++){
       /* st = cart.get(0);
        pname = st.getName();
        qty = st.getQty().toString();
        price = st.getPrice().toString();

       //  Background background = new Background(this);
       //  background.execute(uid,pname,qty,price);
          /*  StringRequest strReq = new StringRequest(Request.Method.POST,
                    Config.ORDER_URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jObj = new JSONObject(response);
                        boolean error = jObj.getBoolean("error");
                        if (!error) {
                            flag[0] =0;//         Toast.makeText(getApplicationContext(),"Enquiry Succesfully Placed ",Toast.LENGTH_LONG).show();
                        } else {
                            String errorMsg = jObj.getString("error_msg");
                            Toast.makeText(getApplicationContext(),
                                    errorMsg, Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    //Log.e(TAG, "Registration Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting params to register url

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("uid",uid);
                    params.put("pname", pname);
                    params.put("qty",qty);
                    params.put("price",price);
                    return params;
                }
            };
            Singleton.getInstance().addToRequestQueue(strReq, tag_string_req);
       // }
        if(flag[0]==0){
            Toast.makeText(getApplicationContext(),"Successs",Toast.LENGTH_LONG).show();
    }
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"saraogi.raj40@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Order");
        i.putExtra(Intent.EXTRA_TEXT,arr);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }*/
    }

    public String Oid() {
        final String[] o = new String[1];
        class Back extends AsyncTask<String, Void, String> {
            Context context;
            InputStream is = null;

            public Back(Context context) {
                this.context = context;
            }

            @Override
            protected String doInBackground(String... params) {
                String uid = params[0];
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("uid", uid));
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(Config.OID_URL);
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }

                    oid = sb.toString();
                    //   o = sb.toString();
                    Log.d("oid ", oid);
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return oid;
            }

            @Override
            protected void onPostExecute(String oid) {
                super.onPostExecute(oid);
                c(oid);
                e();
                //clear();
            }
        }
        Back back = new Back(this);
        // Log.d("oid :", oid);
        back.execute(uid);
        clear();
        return o[0];
    }
    public void c(String oid) {
        //Toast.makeText(this, "oid is " + oid, Toast.LENGTH_LONG).show();
        for (int i = 0; i < cart.size(); i++) {
            st = cart.get(i);
            pname = st.getName();
            qty = st.getQty().toString();
            price = st.getPrice().toString();
            Background background = new Background(getApplicationContext());
            background.execute(uid, pname, qty, price, oid);
        }
    }
    public void e(){
        Toast.makeText(getApplicationContext(),"Thanks For Placing The enquiry",Toast.LENGTH_LONG).show();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"sureshtraders.ahmedabad@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Order");
        i.putExtra(Intent.EXTRA_TEXT, arr);
        try {
            startActivity(Intent.createChooser(i, "Kindly email us Also"));
           // clear();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
    public void clear(){
        cart.clear();
        Intent in = new Intent(getApplicationContext(),MyCart.class);
        startActivity(in);
        finish();
    }
}


