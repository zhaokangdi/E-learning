package com.example.e_learning;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MyfragmentViewpageAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyfragmentViewpageAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
