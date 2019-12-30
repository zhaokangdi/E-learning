package com.example.e_learning;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class CurrentFragment3 extends Fragment {

    private ImageView img_eye1;
    private ImageView img_eye2;
    private EditText setting_studentid;
    private EditText setting_email;
    private EditText input1;
    private EditText input2;
    private Button setting_confirm;
    private Button setting_back;

    private boolean showPwd1 = false;//默认不显示密码
    private boolean showPwd2 = false;//默认不显示密码

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_personal_setting, container,false);

        img_eye1 = (ImageView) v.findViewById(R.id.inputPic1);
        img_eye2 = (ImageView) v.findViewById(R.id.inputPic2);
        setting_studentid = (EditText) v.findViewById(R.id.setting_studentid);
        setting_studentid.setEnabled(false);
        setting_email = (EditText) v.findViewById(R.id.setting_email);
        setting_email.setEnabled(false);
        input1 = (EditText) v.findViewById(R.id.setting_Pass1);
        input2 = (EditText) v.findViewById(R.id.setting_Pass2);
        setting_confirm = (Button) v.findViewById(R.id.setting_confirm);
        setting_back = (Button) v.findViewById(R.id.setting_back);

        setting_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((input1.getText().toString().equals("")) || (input2.getText().toString().equals(""))) {
                    Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    if(!input1.getText().toString().equals(input2.getText().toString())) {
                        Toast.makeText(getActivity(), "两次密码不同", Toast.LENGTH_SHORT).show();
                    }else {
                        DBOpenHelper helper = new DBOpenHelper(getActivity(),"qianbao.db",null,1);
                        SQLiteDatabase db = helper.getWritableDatabase();
                        //根据画面上输入的账号/密码去数据库中进行查询
                        Cursor c = db.query("user_tb",null,"userID=?",new String[]{setting_studentid.getText().toString()},null,null,null);
                        //如果有查询到数据，说明账号存在，可以进行密码重置操作
                        ContentValues cv = new ContentValues();
                        cv.put("pwd", input1.getText().toString());//editPhone界面上的控件
                        String[] args = {String.valueOf(setting_studentid.getText().toString())};
                        long rowid = db.update("user_tb", cv, "userID=?", args);
                        c.close();
                        db.close();
                        Toast.makeText(getActivity(), "密码重置成功", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        setting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });

        return v;
    }

    private void showOrHiddenPwdWithInputType1(){
        if(! showPwd1){
            showPwd1 = true;
            img_eye1.setImageResource(R.drawable.eyeopen);
            //显示密码
            input1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            showPwd1 = false;
            img_eye1.setImageResource(R.drawable.eyeclose);
            //隐藏密码
            input1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    private void showOrHiddenPwdWithInputType2(){
        if(! showPwd2){
            showPwd2 = true;
            img_eye2.setImageResource(R.drawable.eyeopen);
            //显示密码
            input2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            showPwd2 = false;
            img_eye2.setImageResource(R.drawable.eyeclose);
            //隐藏密码
            input2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}

