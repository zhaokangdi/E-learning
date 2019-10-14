package com.example.e_learning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private ImageView img_eye1;
    private ImageView img_eye2;
    private EditText register_password1;
    private EditText register_password2;
    private Button register;

    private boolean showPwd1 = false;//默认不显示密码
    private boolean showPwd2 = false;//默认不显示密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        img_eye1 = (ImageView) findViewById(R.id.img_eye1);
        img_eye2 = (ImageView) findViewById(R.id.img_eye2);
        register = (Button) findViewById(R.id.register_button);
        register_password1 = (EditText) findViewById(R.id.register_password1);
        register_password2 = (EditText) findViewById(R.id.register_password2);

        img_eye1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showOrHiddenPwdWithInputType1();
            }
        });
        img_eye2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showOrHiddenPwdWithInputType2();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                View register_view = View.inflate(RegisterActivity.this,R.layout.dialog_register,null);
                Button goto_login = (Button) register_view.findViewById(R.id.dialog_register_go_login);
                goto_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                builder.setView(register_view);
                builder.show();
                builder.setCancelable(false);
            }
        });
    }

    private void showOrHiddenPwdWithInputType1(){
        if(! showPwd1){
            showPwd1 = true;
            img_eye1.setImageResource(R.drawable.eyeopen);
            //显示密码
            register_password1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            showPwd1 = false;
            img_eye1.setImageResource(R.drawable.eyeclose);
            //隐藏密码
            register_password1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    private void showOrHiddenPwdWithInputType2(){
        if(! showPwd2){
            showPwd2 = true;
            img_eye2.setImageResource(R.drawable.eyeopen);
            //显示密码
            register_password2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            showPwd2 = false;
            img_eye2.setImageResource(R.drawable.eyeclose);
            //隐藏密码
            register_password2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}
