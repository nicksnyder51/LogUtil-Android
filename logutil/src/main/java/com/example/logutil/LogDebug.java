package com.example.logutil;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * Created by nsnyder on 7/13/2017 for 4Cite Marketing.
 */

public class LogDebug {
    private static String UserDeviceID;
    private static String CID;
    private static String EVENT_DTTM;
    private static int DISPLAY_WIDTH;
    private static int DISPLAY_HEIGHT;
    private static String EVENT_TITLE;
    private static String EmailAddress;


    public static void setCID(String cid) {
        CID = cid;
    }
    public static void setUserDeviceID(String u_d_id) {
        UserDeviceID = u_d_id;
    }
    public static void setEventDttm(String EventDttm) {
        EVENT_DTTM = EventDttm;
    }
    public static void DisplaySize(Context ctx) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) ctx).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        DISPLAY_WIDTH = displayMetrics.widthPixels;
        DISPLAY_HEIGHT = displayMetrics.heightPixels;
    }
    public static void setEventTitle(String eventTitle) {
        EVENT_TITLE = eventTitle;
    }
    public static void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress.trim().toLowerCase();
    }
    public static void displaySharedPrefs(Context ctx) {
        Toast.makeText(ctx, "Cid - " + CID + "\nUser Device ID - " + UserDeviceID + "\nEmail Address - " + EmailAddress,
                Toast.LENGTH_LONG).show();
        Toast.makeText(ctx, "Display size WxH - " + DISPLAY_WIDTH + "x" + DISPLAY_HEIGHT + "\nEvent title - " + EVENT_TITLE +
                        "\nEvent datetime - " + EVENT_DTTM,
                Toast.LENGTH_LONG).show();

    }

}
