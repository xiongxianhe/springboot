package com.jdz.service;

import com.jdz.dao.impl.UserDAOImpl;
import com.jdz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAOImpl userDAO;

    public boolean createUser(User user) {
        return userDAO.doCreate(user);
    }

    public boolean delUser(Integer uid) {
        return userDAO.doDel(uid);
    }

    public User getUser(Integer uid) {
        return userDAO.findByUid(uid);
    }

    public List<User> getAll() {
        return userDAO.findAll();
    }
}
