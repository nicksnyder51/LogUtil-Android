package com.example.logutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by nsnyder on 7/13/2017 for 4Cite Marketing.
 */

public class LogDebug {
    private static String CID;
    private static String UserDeviceID;
    private static String EmailAddress;
    private static String EVENT_DTTM;
    private static String DISPLAY_WIDTH;
    private static String DISPLAY_HEIGHT;
    private static String EVENT_TITLE;
    private static String TZ_OFFSET;
    private static String CONTEXT = "";
    private static String RESPONSE;


    public static void setCID(String cid) {
        CID = cid;
    }
    public static void setUserDeviceID(String u_d_id) {
        UserDeviceID = u_d_id;
    }
    public static void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress.trim().toLowerCase();
    }
    public static void setEventDttm(String EventDttm) {
        EVENT_DTTM = EventDttm;
    }
    public static void setDisplaySize(Context ctx) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) ctx).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        DISPLAY_WIDTH = String.valueOf(displayMetrics.widthPixels);
        DISPLAY_HEIGHT = String.valueOf(displayMetrics.heightPixels);
    }
    public static void setEventTitle(String eventTitle) {
        EVENT_TITLE = eventTitle;
    }
    public static void setTZOffset(int tzOffset) {
        TZ_OFFSET = String.valueOf(tzOffset);
    }
    public static void sendTrackingCall(Context ctx) {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //JSONObject jsonObj = new JSONObject(response);
                    Log.d("Nick", response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        TrackingRequest trackingRequest = new TrackingRequest(CID, UserDeviceID, EmailAddress, EVENT_DTTM, DISPLAY_WIDTH, DISPLAY_HEIGHT, EVENT_TITLE, TZ_OFFSET, CONTEXT, responseListener);
        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(trackingRequest);
    }
}
