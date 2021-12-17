package com.example.notebook.Login.fragment;

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

import com.example.notebook.R;

public class LoginFragment extends Fragment {

    private EditText lgEtUsername, lgEtPassword;
    private CheckBox lgCkRemember;
    private Button lgBtnLogin, lgBtnCreate;

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
    }

    public void initView() {
        lgEtUsername = view.findViewById(R.id.login_et_fragment_username);
        lgEtPassword = view.findViewById(R.id.login_et_fragment_password);
        lgCkRemember = view.findViewById(R.id.login_cb_fragment_remember);
        lgBtnLogin = view.findViewById(R.id.login_btn_fragment_login);
        lgBtnCreate = view.findViewById(R.id.login_btn_fragment_create);
    }

    public void setView(){
        
    }
}