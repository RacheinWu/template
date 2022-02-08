package com.rachein.demo.exception;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CodeMsg {

    private int code;

    private String msg;

    //通用：
    public static CodeMsg SUCCESS = new CodeMsg(200, "success");
    public static CodeMsg BIND_ERROR = new CodeMsg(50001, "参数错误!");
    public static CodeMsg ERROR_SERVER = new CodeMsg(50002, "服务器错误!");
//    public static CodeMsg  = new CodeMsg(500, "!");
    public static CodeMsg AUTH_ERROR = new CodeMsg(50003, "验证错误!");


    //注册类: 5008XX
    public static CodeMsg MAIL_EXITED = new CodeMsg(500801, "邮箱已存在!");
    public static CodeMsg PHONE_EXITED = new CodeMsg(500802, "该手机号已经注册过账号了");

    //登录类： 5007XX
    public static CodeMsg ACCOUNT_NOT_EXITED = new CodeMsg(500701, "账户不存在!");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500702, "密码错误!");


    public CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
