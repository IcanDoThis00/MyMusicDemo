package com.example.mymusicdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mymusicdemo.R;
import com.example.mymusicdemo.utils.UserUtils;
import com.example.mymusicdemo.views.InputView;

public class RegisterActivity extends BaseActivity {

    private InputView mInputPhone,mInputPassword,mInputPasswordConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intView();
    }
    //初始化view
    private void intView(){
        initNavBar(true,"注册",false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
        mInputPasswordConfirm = fd(R.id.input_password_confirm);
    }

    /**
     * 注册按钮点击事件
     * 1. 用户输入合法性验证
     *   用户的手机号  是否输入密码，和确认密码，并且两次输入是否相同  输入的手机号是否已经被注册
     *
     * 2.保存用户输入的手机号和密码（MD5加密密码）
     */
    public void onRegisterClick(View v){
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        String passwordConfirm = mInputPasswordConfirm.getInputStr();

        boolean resul = UserUtils.registerUser(this,phone,password,passwordConfirm);
        if (!resul) return;
//        后退页面
        onBackPressed();
    }
}