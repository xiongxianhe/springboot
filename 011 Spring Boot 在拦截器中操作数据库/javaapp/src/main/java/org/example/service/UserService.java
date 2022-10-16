/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/13 16:13
 * Desc:
 */
package org.example.service;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean addUser(User user){
        return userMapper.doCreate(user);
    }

    public boolean updateUser(User user) {
        return userMapper.doUpdate(user);
    }

    public boolean delUser(Integer uid) {
        return userMapper.doDelByUid(uid);
    }

    public User getInfo(Integer uid) {
        return userMapper.findByUid(uid);
    }

    public List<User> getAll(){
        return userMapper.findAll();
    }
}
