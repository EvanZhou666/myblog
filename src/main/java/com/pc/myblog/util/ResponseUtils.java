package com.pc.myblog.util;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/4 18:14
 **/
public class ResponseUtils<T> {
    private int code;

    private String msg;

    private T data;


    public static  ResponseUtils fail(String msg){
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setCode(-1);
        responseUtils.setMsg(msg);
        return responseUtils;
    }


    public static  <T> ResponseUtils success(T data){
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setCode(1);
        responseUtils.setData(data);
        return responseUtils;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
