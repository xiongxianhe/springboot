/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/16 12:28
 * Desc:
 */
package org.example.frame.context;

import org.example.entity.User;
import org.example.frame.context.IBaseContext;

import java.util.HashMap;
import java.util.Map;

public class JDZContext implements IBaseContext<User> {
    private User currentUser;
    private Map<Object, Object> properties = new HashMap<>();

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Map<Object, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<Object, Object> properties) {
        this.properties = properties;
    }
}
