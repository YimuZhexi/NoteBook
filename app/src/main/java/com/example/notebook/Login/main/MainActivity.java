package com.example.notebook.Login.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.notebook.Login.fragment.CreateDialog;
import com.example.notebook.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lgBtnLogin, lgBtnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("yum","(:)-->> main");
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    public void initView() {
        lgBtnLogin = findViewById(R.id.login_btn_fragment_login);
        lgBtnCreate = findViewById(R.id.login_btn_fragment_create);
    }

    public void setView() {
        lgBtnLogin.setOnClickListener(this);
        lgBtnCreate.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_fragment_login:
                break;
            case R.id.login_btn_fragment_create:
                CreateDialog.newInstance().show(getSupportFragmentManager(), "dialog");
                break;
        }
    }
}