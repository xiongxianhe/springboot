package com.jdz.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer uid;
    private String name;
    //@JsonFormat(pattern = "yyy-mm-dd HH:mm:ss")
    @JSONField(format = "yyy-mm-dd HH:mm:ss")
    private Date birthday;
    @JsonIgnore
    private String addr;

    public User(Integer uid, String name, Date birthday, String addr) {
        this.uid = uid;
        this.name = name;
        this.birthday = birthday;
        this.addr = addr;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
