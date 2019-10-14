package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class CurrentFragment1 extends Fragment {

    private ImageView course1_go;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_courses, container,false);

        course1_go = (ImageView) v.findViewById(R.id.course1_go);

        course1_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), IntroduceActivity.class));
            }
        });

        return v;
    }

}