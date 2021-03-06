package com.ylink.frameworkdemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ylink.frameworkdemo.Constant;
import com.ylink.frameworkdemo.utils.SPUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 自定义拦截器刷新sessionId 首次请求的处理
 * @author twilight
 * @Time 2019-07-21
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            List<String> cookies = new ArrayList<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            String cookieStr = JSONObject.toJSONString(cookies);
            SPUtil.putData(Constant.SP.SP, Constant.SP.SESSION_ID, cookieStr);
        }

        return originalResponse;
    }
}

