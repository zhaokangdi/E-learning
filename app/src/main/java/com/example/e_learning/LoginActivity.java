package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login_studentid;
    private EditText login_password;
    private Button register;
    private Button forget;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_studentid = (EditText) findViewById(R.id.login_studentid);
        login_password = (EditText) findViewById(R.id.login_password);
        register = (Button) findViewById(R.id.login_register);
        forget = (Button) findViewById(R.id.login_forget);
        login  = (Button) findViewById(R.id.login_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(i);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOpenHelper helper = new DBOpenHelper(LoginActivity.this,"qianbao.db",null,1);
                SQLiteDatabase db = helper.getWritableDatabase();
                Cursor c = db.query("user_tb",null,"userID=? and pwd=?",new String[]{login_studentid.getText().toString(),login_password.getText().toString()},null,null,null);
                if(c!=null && c.getCount() >= 1){
                    c.close();
                    db.close();

                    Intent i = new Intent(LoginActivity.this,HouseActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "学号或密码输入错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
