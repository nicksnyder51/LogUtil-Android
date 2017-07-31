package com.example.logutil;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nsnyder on 7/19/2017.
 */

public class TrackingRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "https://track.securedvisit.com";
    private Map<String, String> params;

    public TrackingRequest(String cid, String session, String svem, String dt, String width, String height, String title, String offset,  String context, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("sv_cid", cid);
        params.put("sv_session", session);
        params.put("sv_svem", svem);
        params.put("sv_dt", dt);
        params.put("sv_width", width);
        params.put("sv_height", height);
        params.put("sv_title ", title);
        params.put("sv_tzOffset ", offset);
        params.put("sv_ver", "1.6.6");
        params.put("sv_context", context);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
