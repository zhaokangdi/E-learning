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

    private Button download_button1;
    private Button download_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        download_button1 = (Button) findViewById(R.id.download_button1);
        download_button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(ResourceActivity.this, "下载成功，存储在文件管理Movies文件夹", Toast.LENGTH_SHORT).show();
            }
        });

        download_button2 = (Button) findViewById(R.id.download_button2);
        download_button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(ResourceActivity.this, "下载成功，存储在文件管理Movies文件夹", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
