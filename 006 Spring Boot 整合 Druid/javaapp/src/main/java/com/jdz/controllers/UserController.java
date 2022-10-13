package com.jdz.controllers;

import com.jdz.entity.User;
import com.jdz.service.UserService;
import com.jdz.util.ErrType;
import com.jdz.util.RtData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/add")
    public RtData<User> addUser(User user) {
        if(user.getName() == null || user.getAge() == null || user.getAddr() == null) {
            return rtJson(ErrType.ERR_PARAMS);
        }
        userService.createUser(user);
        return rtJson(user);
    }

    @RequestMapping("/user/info")
    public RtData<User> info(Integer uid) {
        return rtJson(userService.getUser(uid));
    }

    @RequestMapping("/user/del")
    public RtData<Boolean> delUser(Integer uid) {
        return rtJson(userService.delUser(uid));
    }

    @RequestMapping("/user/list")
    public RtData<List<User>> userList() {
        return rtJson(userService.getAll());
    }
}
