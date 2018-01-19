package com.example.aditya.project_onyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Anushka on 19-01-2018.
 */

public class Events_fragment extends Fragment{

    String event[]={"Game Of Thrones","Poetry Event","Gangs of Wasseypur","How It Should Have Ended","sdcsskjcnkljasnkjnlkn","fbethr","evr","rerbe","egege"};
    String content[]={"e35rgf135\ng4165emsnnnnnxuchbsjkmox","w354ergfe654g6","e54rge4rge5smkvnisdmvlk4r","2re4fw65r4g6e","35erf1465erf146er541",
            "e5r4f65e41f35er41g3e5\nr64e","e35rg416e5rg4e54g6jbgfghjklk\njhygfg8u98y7t65dfghjko7g6ftghh8y7g6fghijoihge4","e5fgr4v65\n3s64g84srf5","1248515f41451"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       ListView listView = (ListView)getView().findViewById(R.id.list_view);

        Events_fragment.CustomAdapter customAdapter = new Events_fragment.CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetailsActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation( getActivity(),
                        view.findViewById(R.id.cat),
                        ViewCompat.getTransitionName(view.findViewById(R.id.cat)).toString()).toBundle();
                intent.putExtra("title",event[position]);
                intent.putExtra("desc",content[position]);
                startActivity(intent,bundle);

            }
        });
    }

    class CustomAdapter extends BaseAdapter {

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
            ImageView imageView=convertView.findViewById(R.id.cat);
            TextView textView =  convertView.findViewById(R.id.a);
            TextView textView1= convertView.findViewById(R.id.b);
            imageView.setImageResource(R.drawable.propic);
            textView.setText(event[position]);
            textView1.setText(content[position]);
            return convertView;
        }

    }

}

