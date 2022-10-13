package com.jdz.dao.impl;

import com.jdz.dao.IUserDAO;
import com.jdz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean doCreate(User user) {
        return jdbcTemplate.update("insert into `jdz_user`(`name`, `age`, `addr`) values (?, ?, ?)", user.getName(), user.getAge(), user.getAddr()) > 0;
    }

    @Override
    public boolean doDel(Integer uid) {
        return jdbcTemplate.update("DELETE from `jdz_user` where uid=?", uid) > 0;
    }

    @Override
    public User findByUid(Integer uid) {
        try {
            return jdbcTemplate.queryForObject("select * from `jdz_user` where uid=?", new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUid(rs.getInt(1));
                    user.setName(rs.getString(2));
                    user.setAge(rs.getInt(3));
                    user.setAddr(rs.getString(4));
                    return user;
                }
            }, uid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM `jdz_user`", new BeanPropertyRowMapper<User>(User.class));
    }
}
