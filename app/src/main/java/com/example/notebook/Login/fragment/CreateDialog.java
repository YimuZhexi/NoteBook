package com.example.notebook.Login.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.notebook.R;

public class CreateDialog extends DialogFragment implements View.OnClickListener {

    View view;
    private EditText dlEtUsername, dlEtPassword1, dlEtPassword2;
    private Button dlBtnCreate, dlBtnCancel;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static CreateDialog newInstance() {
        Bundle args = new Bundle();
        CreateDialog fragment = new CreateDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载 xml 布局
        view = inflater.inflate(R.layout.create_dialog, null, false);
        view.setElevation(30);
        initView();
        setView();
        return view;
    }

    public void initView() {
        dlEtUsername = view.findViewById(R.id.create_et_dialog_username);
        dlEtPassword1 = view.findViewById(R.id.create_et_dialog_password);
        dlEtPassword2 = view.findViewById(R.id.create_et_dialog_password2);
        dlBtnCreate = view.findViewById(R.id.create_btn_dialog_create);
        dlBtnCancel = view.findViewById(R.id.create_btn_dialog_cancel);
        sharedPreferences = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setView() {
        dlBtnCreate.setOnClickListener(this);
        dlBtnCancel.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_btn_dialog_create:
                create();
                break;
            case R.id.create_btn_dialog_cancel:
                Toast.makeText(getActivity(), "取消注册", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
        }
    }

    public void create() {
        String username = dlEtUsername.getText().toString();
        String password1 = dlEtPassword1.getText().toString();
        String password2 = dlEtPassword2.getText().toString();
        if(username.equals("")){
            Toast.makeText(getActivity(),"用户名不能为空",Toast.LENGTH_SHORT).show();
        }else {
            if (password1.equals(password2)) {
                Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                editor.remove("username");
                editor.remove("password");
                editor.putString("username", username);
                editor.putString("password", password1);
                editor.commit();
                dismiss();
            }else{
                Toast.makeText(getActivity(),"两次密码不符合，请重新输入",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
