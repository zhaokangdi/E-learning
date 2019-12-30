package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static android.os.SystemClock.sleep;

public class ForgetActivity extends AppCompatActivity {

    private String randomNum;
    private EditText forget_email;
    private EditText forget_certificate;
    private Button return_button;
    private Button send;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        forget_email = (EditText) findViewById(R.id.forget_email);
        forget_certificate = (EditText) findViewById(R.id.forget_certificate);
        return_button = (Button) findViewById(R.id.forget_return);
        send = (Button) findViewById(R.id.forget_code);
        sure = (Button) findViewById(R.id.forget_confirm);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(forget_email.getText().toString().equals("")) {
                    Toast.makeText(ForgetActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    sendTextMail();
                }
            }
        });

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!forget_certificate.getText().toString().equals(randomNum)) {
                    Toast.makeText(ForgetActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(ForgetActivity.this,HouseActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void sendTextMail() {
        randomNum = "";
        Random ran = new Random();
        for(int i = 0; i < 6 ;i++){
            randomNum += ran.nextInt(10);
        }

        SendMailUtil.send(forget_email.getText().toString(), randomNum);
        Toast.makeText(ForgetActivity.this, "发送成功，注意接收", Toast.LENGTH_SHORT).show();
    }
}
