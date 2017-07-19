package com.example.logutil;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by nsnyder on 7/13/2017 for 4Cite Marketing.
 */

public class LogDebug {
    private static String UserDeviceID;
    private static String CID;
    private static String EmailAddress;
    private static String EVENT_DTTM;
    private static String DISPLAY_WIDTH;
    private static String DISPLAY_HEIGHT;
    private static String EVENT_TITLE;
    private static String TZ_OFFSET;
    private static String CONTEXT = "";
    private static JSONObject serverResp;


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
    public static JSONObject displaySharedPrefs(Context ctx) {
        RequestParams rp = new RequestParams();
        rp.add("sv_cid ", CID); rp.add("sv_session", UserDeviceID); rp.add("sv_svem", EmailAddress);
        rp.add("sv_dt", EVENT_DTTM); rp.add("sv_width", DISPLAY_WIDTH); rp.add("sv_height ", DISPLAY_HEIGHT);
        rp.add("sv_title", EVENT_TITLE); rp.add("sv_tzOffset ", TZ_OFFSET); rp.add("sv_ver", "1.6.6"); rp.add("sv_context", CONTEXT);

        HttpUtils.post("https://track.securedvisit.com", rp, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    serverResp = new JSONObject(response.toString());
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    serverResp = new JSONObject(errorResponse.toString());
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        return(serverResp);
    }
}
