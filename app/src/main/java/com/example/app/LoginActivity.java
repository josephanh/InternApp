package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import com.example.app.Dialog.DialogLoading;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);

        DialogLoading dialogLoading = new DialogLoading(LoginActivity.this);
        dialogLoading.onCreate();

        btn_login.setOnClickListener(v -> {
            dialogLoading.onShow();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialogLoading.onHide();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 3000);
        });
    }
}