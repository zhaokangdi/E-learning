package com.example.e_learning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResourceActivity extends AppCompatActivity {

    private TextView resource1_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        resource1_name = (TextView) findViewById(R.id.resource1_name);
        resource1_name.setClickable(true);

        resource1_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResourceActivity.this,VideoActivity.class);
                startActivity(i);
            }
        });
    }
}
