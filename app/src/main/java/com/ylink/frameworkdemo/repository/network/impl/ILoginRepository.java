package com.ylink.frameworkdemo.repository.network.impl;

import androidx.lifecycle.LiveData;

import com.ylink.frameworkdemo.base.BaseDto;
import com.ylink.frameworkdemo.model.dto.LoginDto;
import com.ylink.frameworkdemo.model.vo.LoginVo;

/**
 * 登录
 */
public interface ILoginRepository {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    LiveData<BaseDto<LoginDto>> login(LoginVo loginVo);
}
