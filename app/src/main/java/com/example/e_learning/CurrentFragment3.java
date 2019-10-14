package com.example.e_learning;

import android.content.Intent;
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

    private Button setting_confirm;
    private Button setting_back;

    private boolean showPwd1 = false;//默认不显示密码
    private boolean showPwd2 = false;//默认不显示密码

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_personal_setting, container,false);

        setting_confirm = (Button) v.findViewById(R.id.setting_confirm);
        setting_back = (Button) v.findViewById(R.id.setting_back);

        setting_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "修改成功", Toast.LENGTH_SHORT).show();
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
}

