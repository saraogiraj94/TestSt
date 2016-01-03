package com.example.raj.testst;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by raj on 2/1/16.
 */
public class Singleton {
    private static Singleton singleton=null;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private Singleton()
    {
        requestQueue= Volley.newRequestQueue(MyApplication.getAppContext());
        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            Cache cache = new DiskBasedCache(MyApplication.getAppContext().getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cache, network);
        }
        return requestQueue;
    }
    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}


