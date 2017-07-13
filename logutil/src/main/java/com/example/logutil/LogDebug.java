package com.example.logutil;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by nsnyder on 7/13/2017 for 4Cite Marketing.
 */

public class LogDebug {
    private static String UID;
    private static String CID;

    public static void setUID(String uid) {
        UID = uid;
    }
    public static void setCID(String cid, Activity a) {
        CID = cid;
        Toast.makeText(a, "Cid - " + CID,
                Toast.LENGTH_LONG).show();
    }
}
