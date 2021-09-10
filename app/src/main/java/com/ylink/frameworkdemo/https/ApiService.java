package com.ylink.frameworkdemo.https;

import com.ylink.frameworkdemo.Constant;
import com.ylink.frameworkdemo.base.BaseDto;
import com.ylink.frameworkdemo.model.dto.LoginDto;
import com.ylink.frameworkdemo.model.vo.LoginVo;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * api接口
 *
 * @author twilight
 * @Time 2019-07-21
 *
 * retrofit的注解学习https://blog.csdn.net/qiang_xi/article/details/53959437
 */
public interface ApiService {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @POST(Constant.Server.LOGIN)
    Flowable<BaseDto<LoginDto>> login(@Body LoginVo loginVo);

}
