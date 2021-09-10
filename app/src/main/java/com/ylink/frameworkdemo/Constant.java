package com.ylink.frameworkdemo;

/**
 * 全局常量
 *
 * @author twilight
 * @Time 2020-01-14
 */

public class Constant {
    /**
     * 请求后台的所有API接口都在这里配置;统一管理
     */
    public static class Server {

        //服务器超时时间 16 秒
        public final static int TIME_OUT = 16;
        //测试服务器地址
        public static final String ROOT_URL = "https://payapisit.fuxunpay.com/hibi-pos-adapter/rest/merchant/app/";

        //登录
        public static final String LOGIN = "login";

    }

    /**
     * 服务器返回的状态码
     */
    public static class RespCode {
        //处理成功
        public static final String R000 = "R000";
    }
    /**
     * 全局静态变量
     */
    public static class Param {



    }

    /**
     * sp 常量
     */
    public static class SP {
        public static final String SP = "https_sp";//sp
        public static final String SESSION_ID = "session_id";//
    }
    /**
     * 全局常量
     */
    public static class FINALVALUE {

    }
}
