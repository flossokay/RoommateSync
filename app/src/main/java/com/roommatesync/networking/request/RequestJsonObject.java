package com.roommatesync.networking.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RequestJsonObject extends JsonObjectRequest {

    private Priority mPriority;
    private Map<String, String> headers = new HashMap<>();

    public RequestJsonObject(int method, String url, JSONObject jsonRequest,
                             Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    @Override
    public Priority getPriority() {
        return mPriority == null ? Priority.NORMAL : mPriority;
    }

    //TODO for any custom headers make custom method

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }
}
