package org.example.frame.util;

public class RtData<T> {
    private final Integer code;
    private final String msg;
    private final T data;

    public RtData() {
        this.code = RtCode.SUCCESS.getCode();
        this.msg = RtCode.SUCCESS.getDesc();
        this.data = (T) new Object();
    }

    public RtData(RtCode rt) {
        this.code = rt.getCode();
        this.msg = rt.getDesc();
        this.data = (T) new Object();
    }

    public RtData(T data) {
        this.code = RtCode.SUCCESS.getCode();
        this.msg = RtCode.SUCCESS.getDesc();
        this.data = data;
    }

    public RtData(RtCode rt, T data) {
        this.code = rt.getCode();
        this.msg = rt.getDesc();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> RtData<T> rt() {
        return new RtData<>();
    }

    public static <T> RtData<T> rt(T data) {
        return new RtData<>(data);
    }

    public static <T> RtData<T> rt(RtCode rt) {
        return new RtData<>(rt);
    }

    public static <T> RtData<T> rt(RtCode rt, T data) {
        return new RtData<>(rt, data);
    }
}
