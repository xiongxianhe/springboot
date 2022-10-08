package com.jdz.controllers;

import com.jdz.beans.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @RequestMapping("/info")
    public User info() {
        User user = new User(1, "张三", new Date(), "中国江西");
        return user;
    }

    @RequestMapping("/list")
    public List<User> list() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "张三1", new Date(), "中国江西1"));
        users.add(new User(2, "张三2", new Date(), "中国江西2"));
        users.add(new User(3, "张三3", new Date(), "中国江西3"));
        return users;
    }

    public Map<String, User> order() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("第一名", new User(1, "张三1", new Date(), "中国江西1"));
        userMap.put("第二名", new User(2, "张三2", new Date(), "中国江西2"));
        userMap.put("第三名", new User(3, "张三3", new Date(), "中国江西3"));
        return userMap;
    }
}
