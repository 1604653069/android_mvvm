package com.ylink.frameworkdemo.repository.network;

import androidx.lifecycle.LiveData;

import com.ylink.frameworkdemo.base.BaseDto;
import com.ylink.frameworkdemo.base.BaseRepository;
import com.ylink.frameworkdemo.https.ApiService;
import com.ylink.frameworkdemo.https.RequetRetrofit;
import com.ylink.frameworkdemo.model.dto.LoginDto;
import com.ylink.frameworkdemo.model.vo.LoginVo;
import com.ylink.frameworkdemo.repository.network.impl.ILoginRepository;

/**
 * 登录
 */
public class LoginRepository extends BaseRepository implements ILoginRepository {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @Override
    public LiveData<BaseDto<LoginDto>> login(LoginVo loginVo) {
        return request(RequetRetrofit.getInstance(ApiService.class).login(loginVo)).get();
    }
}
