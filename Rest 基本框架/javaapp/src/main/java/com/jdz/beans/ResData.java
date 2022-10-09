package com.jdz.beans;

import java.util.ArrayList;

public class ResData<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResData() {
        this.code = RESCODE.SUCCESS;
        this.msg = RESCODE.getCodeDesc(this.code);
        this.data = (T) new Object();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
        this.msg = RESCODE.getCodeDesc(this.code);
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
