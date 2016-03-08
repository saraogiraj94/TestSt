package com.example.raj.testst;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raj Saraogi on 28-01-2016.
 */
public class Background extends AsyncTask<String,Void,Void> {
    Context context;

    public Background(Context c) {
        this.context=c;
    }

    @Override
    protected Void doInBackground(String... params) {
        String uid=params[0];
        String pname=params[1];
        String qty=params[2];
        String price =params[3];
       String oid =params[4];
        InputStream is = null;
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("uid",uid));
        nameValuePairs.add(new BasicNameValuePair("pname",pname));
        nameValuePairs.add(new BasicNameValuePair("qty",qty));
        nameValuePairs.add(new BasicNameValuePair("price",price));
        nameValuePairs.add(new BasicNameValuePair("oid",oid));
        String result = null;

        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(Config.ORDER_URL);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            is = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            result = sb.toString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
