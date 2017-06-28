package com.example.myapp.com.example.myapp.connecttoserver;

import org.json.JSONException;

/**
 * Created by 2134 on 6/28/2017.
 */

public interface ResponseListener
{
    public abstract void serverResponse(String response, String path) throws JSONException,Exception;
}
