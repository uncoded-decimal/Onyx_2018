package com.example.aditya.project_onyx;

/**
 * Created by Anushka on 17-01-2018.
 */

import android.app.ProgressDialog;
import android.net.http.RequestQueue;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    final String myTag = "DocsUpload";
    EditText et1,et2,et3,et4, et5;
    Button but;
    ProgressDialog progressDialog;
    com.android.volley.RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        et1=(EditText)findViewById(R.id.pName) ;
        et2=(EditText)findViewById(R.id.pEmail) ;
        et3=(EditText)findViewById(R.id.pCollege) ;
        et4=(EditText)findViewById(R.id.pPhone) ;
        et5=(EditText) findViewById(R.id.pEvent) ;
        but=(Button)findViewById(R.id.send) ;
        queue = Volley.newRequestQueue(getApplicationContext());
        Log.i(myTag, "OnCreate()");
        et5.setText(getIntent().getStringExtra("EventName"));
        //et5.setEditableFactory();

        progressDialog= new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Setting you Up...");

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData(et1.getText().toString(),et2.getText().toString(),et3.getText().toString()
                ,et4.getText().toString(),et5.getText().toString());
            }
        });
    }

    public void postData(final String name, final String email, final String college ,final String phone, final String event) {

        progressDialog.show();
        final String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSdt19FBT6aN2EBVYsItllFKLFfqL50qSxCVY_RZW4xUpsXcqg/formResponse";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                fullUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {
                            Snackbar.make(but, "Successfully Posted", Snackbar.LENGTH_LONG).show();
                            et1.setText(null);
                            et2.setText(null);
                            et3.setText(null);
                            et4.setText(null);
                            et5.setText(null);
                            finish();
                        } else {
                            Snackbar.make(but, "Try Again", Snackbar.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Snackbar.make(but, "Error while Posting Data", Snackbar.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("entry.781202710", name);
                params.put("entry.71603580", email);
                params.put("entry.1895487815", phone);
                params.put("entry_45181195", college);
                params.put("entry_974094215",event);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

}