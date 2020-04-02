package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponeVo implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = -100;

    private int code;
    private String msg;
    private Object data;

    public ResponeVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponeVo isSuccess(Object data) {
        return new ResponeVo(ResponeVo.SUCCESS_CODE, "Success", data);
    }

    public static ResponeVo isFail(String msg) {
        return new ResponeVo(ResponeVo.FAIL_CODE, msg, null);
    }
}
