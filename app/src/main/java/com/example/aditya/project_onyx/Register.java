package com.example.aditya.project_onyx;

/**
 * Created by Anushka on 17-01-2018.
 */

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Register extends Activity {

    final String myTag = "DocsUpload";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Log.i(myTag, "OnCreate()");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                postData();

            }
        });
        t.start();
    }



    public void postData() {

        String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSdt19FBT6aN2EBVYsItllFKLFfqL50qSxCVY_RZW4xUpsXcqg/formResponse";
        HttpRequest mReq = new HttpRequest();
        String col1 = "Helo";
        String col2 = "Wrld";

        String data = "entry_781202710=" + URLEncoder.encode(col1) + "&" +
                "entry_45181195=" + URLEncoder.encode(col2);
        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);
    }

}