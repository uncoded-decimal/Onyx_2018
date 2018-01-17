package com.example.aditya.project_onyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.Key;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView=(ImageView)findViewById(R.id.image);
        TextView textView=(TextView)findViewById(R.id.ttle);
        TextView textView1=(TextView) findViewById(R.id.descr);

        Bundle b=getIntent().getExtras();
        if(b==null)
            return;
        else {
            String title = b.getString("title");
            textView.setText(title);
            textView1.setText(b.getString("desc"));
            imageView.setImageResource(R.drawable.propic);
        }
    }

    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.register)
        {
            Intent i= new Intent(DetailsActivity.this,Register.class);
        }
    }
}
