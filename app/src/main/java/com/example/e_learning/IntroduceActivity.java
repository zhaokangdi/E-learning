package com.example.e_learning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IntroduceActivity extends AppCompatActivity {

    private Button register_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        register_course = (Button) findViewById(R.id.introduce_register_course);

        register_course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IntroduceActivity.this);
                View introduce_view = View.inflate(IntroduceActivity.this,R.layout.dialog_course,null);
                Button dialog_register_know = (Button) introduce_view.findViewById(R.id.dialog_register_know);
                dialog_register_know.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(IntroduceActivity.this,HouseActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                builder.setView(introduce_view);
                builder.show();
                builder.setCancelable(false);
            }
        });

    }
}
