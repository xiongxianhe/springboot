package com.jdz.controllers;


import com.jdz.beans.ResData;

public class BaseController {

    public BaseController() {
        System.out.println("进入 BaseController");
    }

    public <T> ResData<T> rtJson() {
        return new ResData<>();
    }

    public <T> ResData<T> rtJson(Integer code) {
        ResData<T> rs = new ResData<>();
        rs.setCode(code);
        return rs;
    }

    public <T> ResData<T> rtJson(T data) {
        ResData<T> rs = new ResData<>();
        rs.setData(data);
        return rs;
    }

    public <T> ResData<T> rtJson(Integer code, T data) {
        ResData<T> rs = new ResData<>();
        rs.setCode(code);
        rs.setData(data);
        return rs;
    }

}
