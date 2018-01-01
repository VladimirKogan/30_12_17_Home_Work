package com.example.vladik.a30_12_17_home_work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by vladik on 31/12/2017.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Person> persons;


    public MyAdapter(){
        persons = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.my_row, parent, false);
        }
        Person p = persons.get(position);
        TextView name = convertView.findViewById(R.id.row_name);
        TextView phone = convertView.findViewById(R.id.row_phone);
        TextView email = convertView.findViewById(R.id.row_email);
        TextView description = convertView.findViewById(R.id.row_description);

        name.setText(p.getName());
        phone.setText(p.getPhone());
        email.setText(p.getEmail());
        description.setText(p.getDescription());

        return convertView;
    }
    public void addPerson(Person p){
        persons.add(0, p);
        notifyDataSetChanged();
    }
}
