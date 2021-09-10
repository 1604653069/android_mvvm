package com.ylink.frameworkdemo.viewmodel.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ylink.frameworkdemo.base.BaseDto;
import com.ylink.frameworkdemo.model.dto.LoginDto;
import com.ylink.frameworkdemo.model.vo.LoginVo;
import com.ylink.frameworkdemo.repository.network.LoginRepository;
import com.ylink.frameworkdemo.repository.network.impl.ILoginRepository;

/**
 * 登录页面viewmodel
 */
public class LoginViewmodel extends ViewModel {

    public LiveData<BaseDto<LoginDto>> login(LoginVo loginVo){
        ILoginRepository loginRepository = new LoginRepository();
        return loginRepository.login(loginVo);
    }
}
