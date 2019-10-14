package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class CurrentFragment2 extends Fragment {

    private ImageView my_course1_go;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_my_study, container,false);

        my_course1_go = (ImageView) v.findViewById(R.id.my_course1_go);

        my_course1_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResourceActivity.class));
            }
        });

        return v;
    }
}
