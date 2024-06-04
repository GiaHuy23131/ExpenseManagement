package com.example.projectver3.giaodich;



import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projectver3.R;
import com.example.projectver3.model.DanhMuc;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DanhMucGDAdapter extends RecyclerView.Adapter<DanhMucGDAdapter.DanhMucViewHolder> {
    private List<DanhMuc> dsDanhMuc;
    private boolean isIncome;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private ItemTouchHelper touchHelper;



    public DanhMucGDAdapter(List<DanhMuc> danhMucList, Context context, boolean isIncome) {
        this.dsDanhMuc = danhMucList;
        this.context = context;
        this.isIncome = isIncome;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {
        this.touchHelper = touchHelper;
    }

    public interface OnItemClickListener {
        void onItemClick(DanhMuc danhMuc);
    }

    @NonNull
    @Override
    public DanhMucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gd_danhmuc_item_cell, parent, false);
        return new DanhMucViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DanhMucViewHolder holder, int position) {
        DanhMuc danhMuc = dsDanhMuc.get(position);
        holder.bindData(danhMuc);


        //click recyclerView Danh Muc
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(danhMuc);
                notifyDataSetChanged(); // Cập nhật toàn bộ danh sách
                // Lưu giá trị RadioButton đã chọn vào SharedPreferences
                SharedPreferences sharedPreferences = context.getSharedPreferences("DanhMuc", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.apply();

        });

    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (DanhMuc danhMuc : dsDanhMuc) {
            if (isIncome == danhMuc.isLoai()) {
                count++;
            }
        }
        return count;
    }

    public void updateData(ArrayList<DanhMuc> ex, ArrayList<DanhMuc> in) {
        if (!isIncome) {
            dsDanhMuc.clear();
            dsDanhMuc = ex;
        } else {
            dsDanhMuc.clear();
            dsDanhMuc = in;
        }
        notifyDataSetChanged();
    }

    public class DanhMucViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCellName;
        private CircleImageView sivCellDanhMuc;

        public DanhMucViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCellName = itemView.findViewById(R.id.tvCellName);
            sivCellDanhMuc = itemView.findViewById(R.id.sivCellDanhMuc);
        }

        public void bindData(final DanhMuc danhMuc) {
            tvCellName.setText(danhMuc.getTenDanhMuc());

            // Đặt hình ảnh cho ShapeableImageView
            if (danhMuc.getHinh() != null) {
                int resId = itemView.getContext().getResources().getIdentifier(danhMuc.getHinh(), "drawable", itemView.getContext().getPackageName());
                sivCellDanhMuc.setImageResource(resId);
            }
            sivCellDanhMuc.setColorFilter(Color.parseColor(danhMuc.getMau().toString()), PorterDuff.Mode.DST_ATOP);

            // Xử lý khi cell được nhấp
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(danhMuc);
                    }
                }
            });
        }
    }
}
