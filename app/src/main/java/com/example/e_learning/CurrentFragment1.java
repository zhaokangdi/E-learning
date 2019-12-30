package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class CurrentFragment1 extends Fragment {

    private ImageView courses_search;
    private ImageView course1_go;
    private ImageView course2_go;
    private ImageView course3_go;
    private ImageView course4_go;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_courses, container,false);

        courses_search = (ImageView) v.findViewById(R.id.courses_search);
        course1_go = (ImageView) v.findViewById(R.id.course1_go);
        course2_go = (ImageView) v.findViewById(R.id.course2_go);
        course3_go = (ImageView) v.findViewById(R.id.course3_go);
        course4_go = (ImageView) v.findViewById(R.id.course4_go);

        courses_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        course1_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), IntroduceActivity.class));
            }
        });

        course2_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view) {
                startActivity(new Intent(getActivity(), WebIntroduceActivity.class));
            }
        });

        course3_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), IntroduceActivity.class));
            }
        });

        course4_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), IntroduceActivity.class));
            }
        });

        return v;
    }
}