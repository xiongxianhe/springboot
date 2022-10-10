package com.jdz.beans;

public class RtData<T> {
    private Integer code;
    private String msg;
    private T data;

    public RtData() {
        this.code = ErrType.SUCCESS;
        this.msg = ErrType.getDesc(this.code);
        this.data = (T) new Object();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
        this.msg = ErrType.getDesc(this.code);
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
