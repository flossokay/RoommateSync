package com.roommatesync.networking;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Network {

    @Inject
    private RequestQueue requestQueue;

    /**
     * Adds request to the dispatch queue
     * @param request
     */
    public void addToQueue(Request request){
        requestQueue.add(request);
    }

    /**
     * Cancels all network calls in the request queue
     */
    public void cancelAllNetworkCalls(){
        requestQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    /**
     * Cancels network calls that were specified in the request filter
     * @param requestFilter
     */
    public void cancelNetworkCalls(RequestQueue.RequestFilter requestFilter){
        requestQueue.cancelAll(requestFilter);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Getters and Setters
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }
}
