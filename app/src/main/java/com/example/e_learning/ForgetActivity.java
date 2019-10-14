package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetActivity extends AppCompatActivity {

    private Button send;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        send = (Button) findViewById(R.id.forget_code);
        sure = (Button) findViewById(R.id.forget_confirm);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送邮件
            }
        });

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgetActivity.this,HouseActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
