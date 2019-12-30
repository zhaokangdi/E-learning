package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    private Movie mMovie;
    private long mMovieStart;
    private int time = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        // getSupportActionBar().hide();//隐藏标题栏
        setContentView(new CustomGifView(this));
        Thread myThread=new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(2000);//使程序休眠
                    Intent it=new Intent(getApplicationContext(),LoginActivity.class);//启动MainActivity
                    startActivity(it);
                    finish();//关闭当前活动
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }

    class CustomGifView extends View {
        @SuppressLint("ResourceType")
        public CustomGifView(Context context) {
            super(context);
            mMovie = Movie.decodeStream(getResources().openRawResource(R.drawable.frontpage));
        }

        public void onDraw(Canvas canvas) {
            long now = android.os.SystemClock.uptimeMillis();

            if (mMovieStart == 0) { // first time
                mMovieStart = now;
            }
            if (mMovie != null) {
                int dur = mMovie.duration();
                if (dur == 0) {
                    dur = 1000;
                }
                int relTime = (int) ((now - mMovieStart) % dur);
                mMovie.setTime(relTime);
                mMovie.draw(canvas, 210, 620);
                if(time <= 144){
                    invalidate();
                }
                time = time + 1;
            }
        }
    }
}
