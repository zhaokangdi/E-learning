package com.example.e_learning;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CourseDialog extends Dialog implements android.view.View.OnClickListener {
    public CourseDialog(@NonNull Context context) {
        super(context);
    }

    Context context;
    Button dialog_register_know;

    private RegisterDialog.LeaveMyDialogListener listener;

    public interface LeaveMyDialogListener{
        public void onClick(View view);
    }

    public CourseDialog(Context context, RegisterDialog.LeaveMyDialogListener listener) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_course);

        dialog_register_know = (Button) findViewById(R.id.dialog_register_know);
        dialog_register_know.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        listener.onClick(v);
    }
}