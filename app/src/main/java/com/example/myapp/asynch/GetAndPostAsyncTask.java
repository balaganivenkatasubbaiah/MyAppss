package com.example.myapp.asynch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.example.myapp.R;
import com.example.myapp.dialogs.All_Dialogs;
import com.example.myapp.dialogs.Finish_Dialogs;
import com.example.myapp.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

/**
 * Created by 2134 on 6/28/2017.
 */

public class GetAndPostAsyncTask extends AsyncTask<String,Object,String>
{
    private ProgressDialog progressBar;
    private static Context ctx;
    boolean type;
    private boolean show_progress = true;

    private URL url;
    private ResponseListener responseListener;
    private String network;

    public GetAndPostAsyncTask(Context ctx, URL url, ResponseListener listner, boolean post) {
        this.ctx = ctx;
        this.url = url;
        responseListener = listner;
        this.type = post;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        if (show_progress) {

            ProgressDialog progressDialog = new ProgressDialog((Activity) ctx);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressBar = progressDialog;
            progressBar.show();
        }
    }

    @Override
    protected String doInBackground(String... params)
    {

        String response =  "";
        if(hasConnection())
        {
            if(type)
            {

            }
            else
            {
                response = HttpHandler.makeServiceCall(url);
            }
        }
        else
        {
            network = "No Connection";
            System.out.println("post request - " + response);
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result)
    {
        super.onPostExecute(result);
        if(show_progress)
        {
            progressBar.dismiss();
        }
        if(network != null)
        {
            noConnectionAlert();
            return;
        }

        if(result == null || result.isEmpty())
        {
            nullResponseAlert();
        }
        else
        {
            try {
                JSONObject jobj1 = new JSONObject(result);
                if (jobj1.has("messages"))
                {
                    jobj1 = jobj1.getJSONObject("messages");
                    if (jobj1.has("error")) {
                        JSONArray jarr = jobj1.getJSONArray("error");
                        if (jarr.length() > 0) {
                            jobj1 = jarr.getJSONObject(0);
                            if (jobj1.has("message")) {
                                // JSONObject jobj =
                                // jobj1.getJSONObject("message");
                                if (jobj1.getInt("code") == 200) {
                                    SharedPreferences sharedPref = ctx.getSharedPreferences("Login",
                                            Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putString("session_id", "1");
                                    editor.commit();

                                    Finish_Dialogs f_d = new Finish_Dialogs(ctx, 0, Constants.App_name,
                                            "Your session has been timed out.");
                                    f_d.show();
                                }

                            }
                        }
                    }
                } else {
                    responseListener.serverResponse(result, url.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static boolean hasConnection() {
        ConnectivityManager cm = (ConnectivityManager) ctx.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return false;
    }

   private void noConnectionAlert() {

        All_Dialogs dialog = new All_Dialogs(ctx, 0, "Internet Connectivity", "No Internet Connection");
        dialog.show();

    }

    private void nullResponseAlert() {

        Constants.generatetoast(ctx, R.drawable.failed,
                "Something went wrong please try after some time or login again");
        // Finish_Dialogs f_d = new Finish_Dialogs(ctx, 0, Constants.App_name,
        // "");
        // f_d.show();
    }

    public void setShow_progress(boolean show_progress) {
        this.show_progress = show_progress;
    }
}
