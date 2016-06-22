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
    public static final Integer DEFAULT_TAG = 100;

    private SingletonRequestQueue(Context appContext) {
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

    /**
     * Add a request to the queue. A default tag is set when not specified in params
     *
     * @param req Request Object
     * @param <T> Request Type
     */
    public <T> void addToRequestQueue(Request<T> req) {

        getRequestQueue().add(req.setTag(DEFAULT_TAG));
    }

    /**
     * Add a request to the queue with a dedicated tag
     *
     * @param req Request Object
     * @param singletonRequestQueueTag Request Tag
     * @param <T> Request Type
     */
    public <T> void addToRequestQueue(Request<T> req, Integer singletonRequestQueueTag) {

        getRequestQueue().add(req.setTag(singletonRequestQueueTag));
    }

    /**
     * Cancels all requests which contain the same tag. Added requests that did not have a tag specified
     * automatically get the DEFAULT_TAG assigned
     *
     * @param singletonRequestQueueTag Request Tag
     */
    public void cancelAllRequests(Integer singletonRequestQueueTag) {
        getRequestQueue().cancelAll(singletonRequestQueueTag);
    }

    /**
     * Cancels all requests which contain the default tag
     */
    public void cancelAllDefaultRequests() {
        getRequestQueue().cancelAll(DEFAULT_TAG);
    }


}
