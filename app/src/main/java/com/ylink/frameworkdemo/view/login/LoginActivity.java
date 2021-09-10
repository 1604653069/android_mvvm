package com.ylink.frameworkdemo.view.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ylink.frameworkdemo.Constant;
import com.ylink.frameworkdemo.R;
import com.ylink.frameworkdemo.base.BaseDto;
import com.ylink.frameworkdemo.model.dto.LoginDto;
import com.ylink.frameworkdemo.model.vo.LoginVo;
import com.ylink.frameworkdemo.viewmodel.login.LoginViewmodel;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;

    private LoginViewmodel viewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewmodel = ViewModelProviders.of(this).get(LoginViewmodel.class);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * 登录
     */
    private void login(){
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        LoginVo loginVo = new LoginVo();
        loginVo.setUsername(username);
        loginVo.setPassword(password);
        viewmodel.login(loginVo).observe(this, new Observer<BaseDto<LoginDto>>() {
            @Override
            public void onChanged(@Nullable BaseDto<LoginDto> loginDtoBaseDto) {
                if(loginDtoBaseDto.getStatusCode().equals(Constant.RespCode.R000)){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,loginDtoBaseDto.getStatusDesc(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
