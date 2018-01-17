package com.example.aditya.project_onyx;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ViewListActivity extends AppCompatActivity {

    String event[]={"Game Of Thrones","Poetry Event","Gangs of Wasseypur","How It Should Have Ended","sdcsskjcnkljasnkjnlkn","fbethr","evr","rerbe","egege"};
    String content[]={"e35rgf135\ng4165emsnnnnnxuchbsjkmox","w354ergfe654g6","e54rge4rge5smkvnisdmvlk4r","2re4fw65r4g6e","35erf1465erf146er541",
            "e5r4f65e41f35er41g3e5\nr64e","e35rg416e5rg4e54g6jbgfghjklk\njhygfg8u98y7t65dfghjko7g6ftghh8y7g6fghijoihge4","e5fgr4v65\n3s64g84srf5","1248515f41451"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        ListView listView = (ListView)findViewById(R.id.list_view);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ViewListActivity.this,DetailsActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation( ViewListActivity.this,
                        view.findViewById(R.id.cat),
                        ViewCompat.getTransitionName(view.findViewById(R.id.cat)).toString()).toBundle();
                intent.putExtra("title",event[position]);
                intent.putExtra("desc",content[position]);
                startActivity(intent,bundle);

            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return event.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.item,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.cat);
            TextView textView = (TextView) convertView.findViewById(R.id.a);
            TextView textView1= (TextView) convertView.findViewById(R.id.b);
            imageView.setImageResource(R.drawable.propic);
            textView.setText(event[position]);
            textView1.setText(content[position]);
            return convertView;
        }

    }
}