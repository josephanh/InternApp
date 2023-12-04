package com.example.app.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.Interface.OnclickNotification;
import com.example.app.Model.Notification;
import com.example.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder>{
    List<Notification> list;
    Context context;
    OnclickNotification onclickNotification;

    public AdapterNotification(List<Notification> list, Context context, OnclickNotification onclickNotification) {
        this.list = list;
        this.context = context;
        this.onclickNotification = onclickNotification;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification notification = list.get(position);
        Glide.with(context).load(notification.getAvatar()).into(holder.avatar);
        holder.title.setText(notification.getTitle());
        holder.description.setText(notification.getDescription());
        holder.username.setText(notification.getUsername());
        holder.type.setText(notification.getType());

        String color = "";
        int background = R.color.comment;

        if(notification.getType() == "comment") {
            color = "#329F50";
            background = R.color.comment;
        } else if(notification.getType() == "report") {
            color = "#ECA418";
            background = R.color.report;
        } else {
            color = "#174276";
            background = R.color.other;
        }

        holder.colorLabel.setColorFilter(Color.parseColor(color));
        holder.type.setTextColor(Color.parseColor(color));
        Drawable backgroundDrawable = holder.type.getBackground().mutate();
        int tintColor = ContextCompat.getColor(context, background);
        backgroundDrawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        holder.type.setBackground(backgroundDrawable);
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        else return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView avatar; ImageView colorLabel;
        TextView title, username, type, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username);
            title = itemView.findViewById(R.id.title_notification);
            type = itemView.findViewById(R.id.type_notification);
            description = itemView.findViewById(R.id.description);
            colorLabel = itemView.findViewById(R.id.color_label);
        }
    }
}
