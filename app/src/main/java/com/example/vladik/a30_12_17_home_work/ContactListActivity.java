package com.example.vladik.a30_12_17_home_work;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Set;

public class ContactListActivity extends AppCompatActivity implements View.OnClickListener{

    public HashMap<String, SharedPreferences.Editor> editors = new HashMap<>();
    public String name, pass;
    private Button back, add;
    private TextView text;
    private String new_name, new_phone, new_email, new_description, val;
    private Person p;
    SharedPreferences.Editor editor = new SharedPreferences.Editor() {
        @Override
        public SharedPreferences.Editor putString(String key, @Nullable String value) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putStringSet(String key, @Nullable Set<String> values) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putInt(String key, int value) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putLong(String key, long value) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putFloat(String key, float value) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putBoolean(String key, boolean value) {
            return null;
        }

        @Override
        public SharedPreferences.Editor remove(String key) {
            return null;
        }

        @Override
        public SharedPreferences.Editor clear() {
            return null;
        }

        @Override
        public boolean commit() {
            return false;
        }

        @Override
        public void apply() {

        }
    };
    private ListView myList;
    private MyAdapter adapter;
    private static int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            name = intent.getExtras().getString("EMAIL");
            pass = intent.getExtras().getString("PASSWORD");
        }
        back = findViewById(R.id.back_btn);
        add = findViewById(R.id.add_btn);
        back.setOnClickListener(this);
        add.setOnClickListener(this);
        myList = findViewById(R.id.my_list);
        text = findViewById(R.id.empty_list);
        adapter = new MyAdapter();

        myList.setAdapter(adapter);


        val = name + " " + pass;
        boolean x = editors.isEmpty();
        String y;
        if(x)y = "YES";else y="NO";
        if(editors.containsValue(val)){
            editor = editors.get(val);
        }
        Toast.makeText(this, y + pass, Toast.LENGTH_LONG).show();
        //load();


    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.back_btn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.add_btn){
            Intent intent = new Intent(this, AddActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                Intent intent = getIntent();
                new_name = data.getExtras().getString("NAME");
                new_phone = data.getStringExtra("PHONE");
                new_email = data.getStringExtra("EMAIL");
                new_description = data.getStringExtra("DESCRIPTION");
                p = new Person(new_name, new_phone, new_email, new_description);
                Toast.makeText(this, new_name, Toast.LENGTH_LONG).show();
                text.setVisibility(View.GONE);
                adapter.addPerson(p);
                Log.d("MY_TAG", p.toString());
                save();
            }
        }
    }

    private void save(){
        SharedPreferences sharedPreferences = getSharedPreferences(val, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(val + getString(counter++), p.toString());
/*        editor.putString("NAME", p.getName());
        editor.putString("PHONE", p.getPhone());
        editor.putString("EMAIL", p.getEmail());
        editor.putString("DESCR", p.getDescription());*/
        editor.commit();
        Log.d("MY_TAG", "Saved!!!!!!!");
    }

    private void load(){
        SharedPreferences sharedPreferences = getSharedPreferences("DATA", MODE_PRIVATE);
        p.setName(sharedPreferences.getString("NAME", ""));
        p.setPhone(sharedPreferences.getString("PHONE", ""));
        p.setEmail(sharedPreferences.getString("EMAIL", ""));
        p.setDescription(sharedPreferences.getString("DESCR", ""));
    }
}
