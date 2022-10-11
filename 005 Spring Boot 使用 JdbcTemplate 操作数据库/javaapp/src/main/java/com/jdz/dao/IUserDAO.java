package com.jdz.dao;

import com.jdz.entity.User;

import java.util.List;

public interface IUserDAO {

    public boolean doCreate(User user);

    public boolean doDel(Integer uid);

    public User findByUid(Integer uid);

    public List<User> findAll();
}
