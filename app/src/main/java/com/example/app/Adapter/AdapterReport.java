package com.example.app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.Interface.OnclickReport;
import com.example.app.Model.Report;
import com.example.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class AdapterReport extends RecyclerView.Adapter<AdapterReport.ViewHolder> {
    List<Report> list;
    Context context;
    private OnclickReport onclickReport;

    public AdapterReport(List<Report> list, Context context, OnclickReport onclickReport) {
        this.list = list;
        this.context = context;
        this.onclickReport = onclickReport;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_report, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint({"NewApi", "LocalSuppress"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Report report = list.get(position);
        Glide.with(context).load(report.getAvatar()).into(holder.avatar);
        holder.fullName.setText(report.getFullName());

        Instant instant = Instant.parse(report.getDateCreate());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));


        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();

        holder.dateCreate.setText(day + "/" + month + "/" + year);
        holder.description.setText(report.getFullName() + " weekly report");

        holder.itemReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickReport.onClick(report);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        else return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView avatar;
        TextView fullName, dateCreate, description;
        LinearLayout itemReport;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            fullName = itemView.findViewById(R.id.full_name);
            dateCreate = itemView.findViewById(R.id.date_create);
            description = itemView.findViewById(R.id.description);
            itemReport = itemView.findViewById(R.id.item_report);
        }

    }
}
