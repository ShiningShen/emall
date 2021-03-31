package com.example.emall.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    // 0成功，-1失败
    private int status;
    private String msg;
    private Object data;
    private String action;
    private int code;

    public static Result succ() {
        return Result.succ ( "操作成功", null );
    }

    public static Result succ(Object data) {
        return Result.succ ( "操作成功", data );
    }

    public static Result succ(String msg, Object data) {
        Result result = new Result ();
        result.status = 0;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result ();
        result.status = -1;
        result.data = null;
        result.msg = msg;
        return result;
    }
    /**
     * 异常调用
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result fail(int code ,String msg,Object data){
        Result r=new Result ();
        r.setCode ( code );
        r.setData ( data );
        r.setMsg ( msg );
        return r;
    }

    public Result action(String action) {
        this.action = action;
        return this;
    }
}

