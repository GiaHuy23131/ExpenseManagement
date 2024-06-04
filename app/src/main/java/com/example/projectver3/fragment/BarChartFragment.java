package com.example.projectver3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectver3.R;
import com.example.projectver3.adapter.ViewPageBarCharAdapter;
import com.example.projectver3.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class BarChartFragment extends Fragment {
     TabLayout tabLayoutBarChart;

     ViewPager mViewPagerBarChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        tabLayoutBarChart = view.findViewById(R.id.tab_layout_BarChart);
        mViewPagerBarChart = view.findViewById(R.id.view_pagerBarChart);

        ViewPageBarCharAdapter viewPageBarCharAdapter = new ViewPageBarCharAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPagerBarChart.setAdapter(viewPageBarCharAdapter);

        tabLayoutBarChart.setupWithViewPager(mViewPagerBarChart);
        return view;
    }
}