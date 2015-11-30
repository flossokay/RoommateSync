package com.roommatesync.networking.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class RequestJsonArray extends JsonArrayRequest{

    private Priority mPriority;
    private Map<String, String> headers = new HashMap<>();

    public RequestJsonArray(String url, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener){
        super(url, listener, errorListener);
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }
    //TODO for any custom headers make custom method

    @Override
    public Priority getPriority() {
        return mPriority == null ? Priority.NORMAL : mPriority;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }
}
