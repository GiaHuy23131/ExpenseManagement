package com.example.projectver3.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectver3.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarChartThuNhapFragment extends Fragment {

    BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart_thunhap, container, false);
        setControl(view);
        ArrayList<BarEntry> barEnteries = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            float value = (float) (i*10.0);
            BarEntry barEntry = new BarEntry(i,value);
            barEnteries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(barEnteries,"Employees");
        barDataSet.setColor(Color.BLUE);
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(3000);
        barChart.getDescription().setText("Chart");
        barChart.getDescription().setTextColor(Color.GREEN);
        return view;
    }
    private void setControl(View view) {
        barChart = view.findViewById(R.id.bar_chart_TN);

    }



}