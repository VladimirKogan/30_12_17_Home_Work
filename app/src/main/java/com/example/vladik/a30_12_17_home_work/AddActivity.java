package com.example.vladik.a30_12_17_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ok_btn, show_btn;
    EditText new_name, new_phone, new_email, new_description;
    String new_name_str, new_phone_str, new_email_str, new_description_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ok_btn = findViewById(R.id.ok_btn);
        show_btn = findViewById(R.id.show);
        new_name = findViewById(R.id.name_input);
        new_phone = findViewById(R.id.phone_input);
        new_email = findViewById(R.id.email_input);
        new_description = findViewById(R.id.description_input);

        ok_btn.setOnClickListener(this);
        show_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.show){
            new_name_str = new_name.getText().toString();
            new_phone_str = new_phone.getText().toString();
            new_email_str = new_email.getText().toString();
            new_description_str = new_description.getText().toString();
            Toast.makeText(this, new_name_str, Toast.LENGTH_LONG).show();
        }
        if(v.getId() == R.id.ok_btn){
            new_name_str = new_name.getText().toString();
            new_phone_str = new_phone.getText().toString();
            new_email_str = new_email.getText().toString();
            new_description_str = new_description.getText().toString();

            Intent data = new Intent();
            data.putExtra("NAME", new_name_str);
            data.putExtra("PHONE", new_phone_str);
            data.putExtra("EMAIL", new_email_str);
            data.putExtra("DESCRIPTION", new_description_str);
            data.putExtra("CALLBACK", "HOPA");
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
