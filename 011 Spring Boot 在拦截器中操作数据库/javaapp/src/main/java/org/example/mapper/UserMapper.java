/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/13 15:55
 * Desc:
 */
package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    public boolean doCreate(User user);

    public boolean doUpdate(User user);

    public boolean doDelByUid(Integer uid);

    public User findByUid(Integer uid);

    public List<User> findAll();
}
