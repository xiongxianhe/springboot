/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/13 16:17
 * Desc:
 */
package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "ok";
    }

    @RequestMapping("/user/save")
    public boolean saveUser(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping("/user/del")
    public String delUser(Integer uid) {
        userService.delUser(uid);
        return "ok";
    }

    @RequestMapping("/user/info")
    public User info(Integer uid) {
        return userService.getInfo(uid);
    }

    @RequestMapping("/user/list")
    public List<User> userList() {
        return userService.getAll();
    }
}
