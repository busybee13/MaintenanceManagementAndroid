package com.torchacademy.maintenancemanagement;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by omar.beyhum on 6/20/2016.
 */
public class SingletonRequestQueue {
    private static SingletonRequestQueue requestQueueInstance;
    private RequestQueue mRequestQueue;
    private static Context appContext;

    private SingletonRequestQueue(Context appContext){
        // context passed will always be application context regardless of passed parameter
        this.appContext = appContext.getApplicationContext();
        mRequestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(appContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public static synchronized SingletonRequestQueue getInstance(Context context) {
        if (requestQueueInstance == null) {
            requestQueueInstance = new SingletonRequestQueue(context);
        }
        return requestQueueInstance;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
