package com.example.projectver3.fragment;

import static com.example.projectver3.HomeActivity.thongKeCP;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.projectver3.R;
import com.example.projectver3.model.ThongKe;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class BarChartChiPhiFragment extends Fragment implements OnChartValueSelectedListener {

    BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart_chiphi, container, false);
        setControl(view);
//        ArrayList<BarEntry> barEnteries = new ArrayList<>();
//        for (int i = 0; i < 5; i++){
//            float value = (float) (i*10.0);
//            BarEntry barEntry = new BarEntry(i,value);
//            barEnteries.add(barEntry);
//        }
//        BarDataSet barDataSet = new BarDataSet(barEnteries,"Employees");
//        barDataSet.setColor(Color.BLUE);
//        barDataSet.setDrawValues(false);
//        barChart.setData(new BarData(barDataSet));
//        barChart.animateY(3000);
//        barChart.getDescription().setText("Chart");
//        barChart.getDescription().setTextColor(Color.GREEN);
        //set thông tin giao diện cho biểu đồ
        barChart.setDescription(new Description());

        barChart.animateY(1000);
        barChart.setDragEnabled(true);
        barChart.setOnChartValueSelectedListener(this);
        //set dữ liệu vào biểu đồ
        addDataSet(barChart);
        return view;
    }
    private void setControl(View view) {
        barChart = view.findViewById(R.id.bar_chart_CP);

    }
    //hàm set dữ liệu vào biểu đồ
    private void addDataSet(BarChart barChart) {
        //khai báo
        ArrayList<BarEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        ArrayList<String> xData = new ArrayList<>();
        ArrayList<Float> yData = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        //đổ dữ liệu từ thống kê
        for (ThongKe data : thongKeCP
        ) {
            xData.add(data.getTenGD());
            yData.add(data.getTongTien());
            colors.add(Color.parseColor(data.getMau().toString()));
            Log.d("mau", data.getMau());
            Log.d("mau cp", colors.toString());
        }

        for (int i = 0; i < yData.size(); i++) {
            yEntrys.add(new BarEntry(yData.get(i), i));
        }
        for (int i = 0; i < xData.size(); i++) {
            xEntrys.add(xData.get(i));
        }
        //set các thông số cho biểu đồ
        BarDataSet barDataSet = new BarDataSet(yEntrys, "Chi Phí");
        barDataSet.setValueTextSize(12);
        barDataSet.setColors(colors);
        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}