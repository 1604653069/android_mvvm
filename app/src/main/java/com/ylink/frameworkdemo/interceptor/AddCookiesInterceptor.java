package com.ylink.frameworkdemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ylink.frameworkdemo.Constant;
import com.ylink.frameworkdemo.utils.SPUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 自定义拦截器刷新sessionId  非首次请求的处理
 * @author twilight
 * @Time 2019-07-21
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String cookieStr = SPUtil.getData(Constant.SP.SP, Constant.SP.SESSION_ID, String.class, null);
        List<String> cookies = JSONObject.parseArray(cookieStr, String.class);
        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}

