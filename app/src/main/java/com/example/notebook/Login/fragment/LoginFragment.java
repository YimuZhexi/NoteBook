package com.example.notebook.Login.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.notebook.Login.main.MainActivity;
import com.example.notebook.R;

public class LoginFragment extends Fragment {

    private EditText lgEtUsername, lgEtPassword;
    private CheckBox lgCkRemember;
    SharedPreferences sharedPreferences;

    View view;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setView();
        remember();
    }

    //初始化界面
    public void initView() {
        lgEtUsername = view.findViewById(R.id.login_et_fragment_username);
        lgEtPassword = view.findViewById(R.id.login_et_fragment_password);
        lgCkRemember = view.findViewById(R.id.login_cb_fragment_remember);
        sharedPreferences = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
    }

    //设置界面
    public void setView() {
        lgCkRemember.setChecked(false);
    }

    //记住密码
    public void remember() {
        if (lgCkRemember.isChecked()) {
            String username = sharedPreferences.getString("username", "");
            String password = sharedPreferences.getString("password", "");
            lgEtUsername.setText(username);
            lgEtPassword.setText(password);
        }
    }
}