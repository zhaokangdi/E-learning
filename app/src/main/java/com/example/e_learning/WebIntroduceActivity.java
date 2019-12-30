package com.example.e_learning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class WebIntroduceActivity extends AppCompatActivity {

    private Button register_course;
    private Button look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_introduce);

        register_course = (Button) findViewById(R.id.introduce_register_course);
        look = (Button) findViewById(R.id.look);

        register_course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WebIntroduceActivity.this);
                View introduce_view = View.inflate(WebIntroduceActivity.this,R.layout.dialog_course,null);
                Button dialog_register_know = (Button) introduce_view.findViewById(R.id.dialog_register_know);
                dialog_register_know.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(WebIntroduceActivity.this,HouseActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                builder.setView(introduce_view);
                builder.show();
                builder.setCancelable(false);
            }
        });

        look.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatePickerDialog dp = new DatePickerDialog(WebIntroduceActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {
                        long maxDate = datePicker.getMaxDate();
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int dayOfMonth1 = datePicker.getDayOfMonth();
                        Toast.makeText(getApplicationContext(), "本周课程时间：" + iyear +"/"+ monthOfYear+"/"+dayOfMonth , Toast.LENGTH_LONG).show();
                    }}, 2019, 11, 27);
                dp.show();
            }
        });
    }
}
