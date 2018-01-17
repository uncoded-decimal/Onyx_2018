package com.example.aditya.project_onyx;

/**
 * Created by Anushka on 17-01-2018.
 */

import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

    final String myTag = "DocsUpload";
    EditText et1,et2,et3,et4;
    TextView et5;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        et1=(EditText)findViewById(R.id.pName) ;
        et2=(EditText)findViewById(R.id.pEmail) ;
        et3=(EditText)findViewById(R.id.pCollege) ;
        et4=(EditText)findViewById(R.id.pPhone) ;
        et5=(TextView) findViewById(R.id.pEvent) ;
        but=(Button)findViewById(R.id.send) ;
        Log.i(myTag, "OnCreate()");

        Bundle b=getIntent().getExtras();
        et5.setText(b.getString("title"));

        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                postData();

            }
        });
        t.start();


    }

    public void postData() {

        final String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSdt19FBT6aN2EBVYsItllFKLFfqL50qSxCVY_RZW4xUpsXcqg/formResponse";
        final HttpRequest mReq = new HttpRequest();
        final String name = et1.getText().toString();
        final String email = et2.getText().toString();
        final String college = et3.getText().toString();
        final String phone = et4.getText().toString();
        final String event = et5.getText().toString();
        final String data = "entry_781202710=" + URLEncoder.encode(name) + "&" +
                "entry_45181195=" + URLEncoder.encode(college) + "&" + "entry_71603580=" +
                URLEncoder.encode(email)+ "&" + "entry_1895487815=" + URLEncoder.encode(phone) + "&" +
                "entry_974094215=" + URLEncoder.encode(event);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name!=null && college!=null && phone!=null && email!=null && event!=null){
                String response;
                mReq.sendPost(fullUrl, data);
                finish();
                //Log.i(myTag, response);
                }
                else
                    Toast.makeText(Register.this,"One Field left Empty", Toast.LENGTH_SHORT).show();
            }
        });

    }

}