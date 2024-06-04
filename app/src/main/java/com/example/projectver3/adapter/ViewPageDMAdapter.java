package com.example.projectver3.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projectver3.fragment.BarChartChiPhiFragment;
import com.example.projectver3.fragment.BarChartThuNhapFragment;
import com.example.projectver3.fragment.DanhMucExpenseFragment;
import com.example.projectver3.fragment.DanhMucIncomeFragment;
import com.example.projectver3.model.DanhMuc;

import java.util.ArrayList;
import java.util.List;

public class ViewPageDMAdapter extends FragmentStateAdapter {

    private ArrayList<DanhMuc> danhMucList;
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public ViewPageDMAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BarChartChiPhiFragment();
            case 1:
                return new BarChartThuNhapFragment();
            default:
                return new BarChartChiPhiFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }



}
