package com.example.e_learning;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HouseActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    Drawable drawable,drawable1,drawable2,drawable3;
    // 布局文件中自己的myvirwpager
    private ViewPager myvirwpager;
    // 选项卡中的三个Button
    private Button one, two, three;
    // 指示标签的ImageView
    private ImageView cursor;
    // 指示标签的横坐标
    private float cursorX = 0;
    // 定义获取所有按钮的宽度数组
    private int[] WidrhArgs;
    // 定义所有标题按钮的数组
    private Button[] ButtonArgs;
    private ImageView[] PicArgs;
    // fragment的集合
    private ArrayList<Fragment> list;
    // viewpage适配器
    private MyfragmentViewpageAdapter adapter;
    FragmentManager fm=getSupportFragmentManager();

    private ImageView buttonPic1,buttonPic2,buttonPic3;

    CurrentFragment1 currency1;
    CurrentFragment2 currency2;
    CurrentFragment3 currency3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        Init();
    }

    private void Init() {
        // 获取控件
        myvirwpager = (ViewPager) findViewById(R.id.viewpager);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);

        buttonPic1 = (ImageView) findViewById(R.id.buttonPic1);
        buttonPic2 = (ImageView) findViewById(R.id.buttonPic2);
        buttonPic3 = (ImageView) findViewById(R.id.buttonPic3);

        // 初始化按钮数组
        ButtonArgs = new Button[] { one, two, three };
        PicArgs    = new ImageView[]{buttonPic1,buttonPic2,buttonPic3};
        // 设置指示标签颜色为红色
        cursor = (ImageView) findViewById(R.id.cursor);
        cursor.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        // 按钮单机事件
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        buttonPic1.setOnClickListener(this);
        buttonPic2.setOnClickListener(this);
        buttonPic3.setOnClickListener(this);

        // 将fragment放进集合，并初始化适配器
        currency1 = new CurrentFragment1();
        currency2 = new CurrentFragment2();
        currency3 = new CurrentFragment3();
        list = new ArrayList<Fragment>();
        list.add(currency1);
        list.add(currency2);
        list.add(currency3);
        adapter = new MyfragmentViewpageAdapter(fm, list);
        myvirwpager.setAdapter(adapter);
        // viewpage监听事件，重写onPageSelected()方法，实现左右滑动页面
        myvirwpager.addOnPageChangeListener(this);
        // 初始按钮颜色
        resetButtonColor();
        // 默认第一页
        onPageSelected(0);
    }

    // 设置按钮颜色
    public void resetButtonColor() {
        one.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        two.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        three.setBackgroundColor(Color.parseColor("#00FFFFFF"));

        one.setTextColor(Color.BLACK);
        two.setTextColor(Color.BLACK);
        three.setTextColor(Color.BLACK);

        drawable1 = getResources().getDrawable(R.drawable.courses);
        drawable2 = getResources().getDrawable(R.drawable.my_study);
        drawable3 = getResources().getDrawable(R.drawable.personal_setting);
        Drawable wrapDrawable1 = DrawableCompat.wrap(drawable1);
        Drawable wrapDrawable2 = DrawableCompat.wrap(drawable2);
        Drawable wrapDrawable3 = DrawableCompat.wrap(drawable3);
        DrawableCompat.setTintList(wrapDrawable1, ColorStateList.valueOf(getResources().getColor(R.color.colorBlack)));
        DrawableCompat.setTintList(wrapDrawable2, ColorStateList.valueOf(getResources().getColor(R.color.colorBlack)));
        DrawableCompat.setTintList(wrapDrawable3, ColorStateList.valueOf(getResources().getColor(R.color.colorBlack)));
        PicArgs[0].setImageDrawable(wrapDrawable1);
        PicArgs[1].setImageDrawable(wrapDrawable2);
        PicArgs[2].setImageDrawable(wrapDrawable3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2) {
            myvirwpager.setCurrentItem(2);
            cursorAnim(2);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                myvirwpager.setCurrentItem(0);
                cursorAnim(0);
                break;
            case R.id.two:
                myvirwpager.setCurrentItem(1);
                cursorAnim(1);
                break;
            case R.id.three:
                myvirwpager.setCurrentItem(2);
                cursorAnim(2);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        if (WidrhArgs == null) {
            WidrhArgs = new int[] { one.getWidth(), two.getWidth(),
                    three.getWidth() };
        }

        // 根据每次选中的按钮，重置颜色
        resetButtonColor();
        // 将滑动到当前的标签下，改动标签颜色
        ButtonArgs[arg0].setTextColor(getResources().getColor(R.color.colorPrimary));
        switch(arg0){
            case 0:
                drawable = getResources().getDrawable(R.drawable.courses);
                break;
            case 1:
                drawable = getResources().getDrawable(R.drawable.my_study);
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.personal_setting);
                break;
        }
        Drawable wrapDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrapDrawable, ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
        PicArgs[arg0].setImageDrawable(wrapDrawable);
        cursorAnim(arg0);
    }

    // 指示器的跳转，传入当前所处的页面的下标
    public void cursorAnim(int curItem) {
        // 每次调用，就将指示器的横坐标设置为0，即开始的位置
        cursorX = 0;
        // 再根据当前的curItem来设置指示器的宽度
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) cursor.getLayoutParams();
        // 减去边距*2，以对齐标题栏文字
        lp.width = 362;
        cursor.setLayoutParams(lp);
        // 循环获取当前页之前的所有页面的宽度
        for (int i = 0; i < curItem; i++) {
            cursorX = cursorX + ButtonArgs[i].getWidth();
        }
        // 再加上当前页面的左边距，即为指示器当前应处的位置
        cursor.setX(cursorX + ButtonArgs[curItem].getPaddingLeft());
    }
}

