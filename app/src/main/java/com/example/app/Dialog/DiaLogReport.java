package com.example.app.Dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.Model.Report;
import com.example.app.R;

public class DiaLogReport {
    Context context;
    AlertDialog dialog;
    public DiaLogReport(Context context) {
        this.context = context;
    }

    public void onCreate(Report report){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_report, null);
        builder.setView(view);
        TextView fullName = view.findViewById(R.id.full_name);
        Button btnOk = view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v -> onHide());
        fullName.setText(report.getFullName());
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
    public void onShow(){
        dialog.show();
    }
    public void onHide(){
        dialog.dismiss();
    }
}
