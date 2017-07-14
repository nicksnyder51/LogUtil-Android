package com.example.logutil;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by nsnyder on 7/13/2017 for 4Cite Marketing.
 */

public class LogDebug {
    private static String UserDeviceID;
    private static String CID;
    private static String EmailAddress;

    public static void setUserDeviceID(String u_d_id) {
        UserDeviceID = u_d_id;
    }
    public static void setCID(String cid) {
        CID = cid;
    }
    public static void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress.trim().toLowerCase();
    }
    public static void displaySharedPrefs(Context ctx) {
        Toast.makeText(ctx, "Cid - " + CID + "\nUser Device ID - " + UserDeviceID + "\nEmail Address - " + EmailAddress,
                Toast.LENGTH_LONG).show();
    }

}
