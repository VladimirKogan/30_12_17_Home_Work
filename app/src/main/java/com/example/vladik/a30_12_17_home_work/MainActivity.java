package com.example.vladik.a30_12_17_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText log_email, log_pass;
    String log_email_str, log_pass_str;
    Button log_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_email = findViewById(R.id.login_email);
        log_pass = findViewById(R.id.login_password);

        log_btn = findViewById(R.id.login_btn);
        log_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn) {
            log_email_str = log_email.getText().toString();
            log_pass_str = log_pass.getText().toString();
            Intent intent = new Intent(this, ContactListActivity.class);
            intent.putExtra("EMAIL", log_email_str);
            intent.putExtra("PASSWORD", log_pass_str);
            startActivity(intent);
        }
    }
}
