package com.jdz.controllers;


import com.jdz.util.RtData;

public class BaseController {

    /**
     * 默认返回值
     */
    public <T> RtData<T> rtJson() {
        return new RtData<>();
    }

    /**
     * 定义 code 返回值
     */
    public <T> RtData<T> rtJson(Integer code) {
        RtData<T> rtData = new RtData<>();
        rtData.setCode(code);
        return rtData;
    }

    /**
     * 定义 data 返回值
     */
    public <T> RtData<T> rtJson(T data) {
        RtData<T> rtData = new RtData<>();
        rtData.setData(data);
        return rtData;
    }

    /**
     * 定义 code 和 data 返回值
     */
    public <T> RtData<T> rtJson(Integer code, T data) {
        RtData<T> rtData = new RtData<>();
        rtData.setCode(code);
        rtData.setData(data);
        return rtData;
    }
}
