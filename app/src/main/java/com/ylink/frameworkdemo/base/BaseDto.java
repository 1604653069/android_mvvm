package com.ylink.frameworkdemo.base;

import java.io.Serializable;

/**
 * 服务器返回公共实体
 *
 * @param <T>
 * @author twilight
 * @Time 2019-07-21
 */
public class BaseDto<T> implements Serializable {
    private String statusCode;
    private String statusDesc;
    private T data;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
