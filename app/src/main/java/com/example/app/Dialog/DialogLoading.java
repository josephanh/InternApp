package com.example.app.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.app.R;

public class DialogLoading {
    Context context;
    AlertDialog dialog;
    public DialogLoading(Context context) {
        this.context = context;
    }

    public void onCreate(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(LayoutInflater.from(context).inflate(R.layout.dialog_loadding, null));
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
