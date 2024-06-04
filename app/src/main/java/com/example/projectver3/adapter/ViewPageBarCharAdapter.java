package com.example.projectver3.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projectver3.fragment.BarChartChiPhiFragment;
import com.example.projectver3.fragment.BarChartThuNhapFragment;

public class ViewPageBarCharAdapter extends FragmentStatePagerAdapter {

    public ViewPageBarCharAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BarChartChiPhiFragment();
            case 1:
                return new BarChartThuNhapFragment();
            default:
                return new BarChartChiPhiFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0:
                title = "Chi Phí";
                break;
            case 1:
                title = "Thu Nhập";
                break;
        }
        return title;
    }
}
