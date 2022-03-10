package edu.jsu.mcis.cs408.tablayoutdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch(position){
            case 0: // tip
                fragment = new FirstFragment();
                break;
            case 1: // temp
                fragment = new TempConvert();
                break;
            case 2: // dist
                fragment = new DistConvert();
                break;
            default: // default to tip
                fragment = new FirstFragment();
                break;

        }
        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}