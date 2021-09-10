package com.ylink.frameworkdemo.base;

import androidx.lifecycle.MutableLiveData;

import com.ylink.frameworkdemo.Constant;
import com.ylink.frameworkdemo.exception.ApiException;
import com.ylink.frameworkdemo.exception.ExceptionEngine;
import com.ylink.frameworkdemo.exception.ServerException;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * 自定义请服务器被观察者
 *
 * @author twilight
 * @Time 2019-07-21
 */
public class BaseHttpSubscriber<T> implements Subscriber<BaseDto<T>> {

    //异常类
    private ApiException ex;

    public BaseHttpSubscriber() {
        data = new MutableLiveData();
    }

    private MutableLiveData<BaseDto<T>> data;

    public MutableLiveData<BaseDto<T>> get() {
        return data;
    }

    public void set(BaseDto<T> t) {
        this.data.setValue(t);
    }

    public void onFinish(BaseDto<T> t) {
        set(t);
    }

    @Override
    public void onSubscribe(Subscription s) {
        // 观察者接收事件 = 1个
        s.request(1);
    }

    @Override
    public void onNext(BaseDto<T> t) {
        if (t.getStatusCode().equals(Constant.RespCode.R000)) {
            onFinish(t);
        } else{
            ex = ExceptionEngine.handleException(new ServerException(t.getStatusCode(), t.getStatusDesc()));
            getErrorDto(ex);
        }
    }

    @Override
    public void onError(Throwable t) {
        ex = ExceptionEngine.handleException(t);
        getErrorDto(ex);
    }

    /**
     * 初始化错误的dto
     *
     * @param ex
     */
    private void getErrorDto(ApiException ex) {
        BaseDto dto = new BaseDto();
        dto.setStatusCode(ex.getStatusCode());
        dto.setStatusDesc(ex.getStatusDesc());
        onFinish((BaseDto<T>) dto);
    }

    @Override
    public void onComplete() {
    }

}
