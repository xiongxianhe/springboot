/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/16 12:26
 * Desc:
 */
package org.example.frame.context;

import java.io.Serializable;
import java.util.Map;

public interface IBaseContext<T> extends Serializable {
    T getCurrentUser();

    void setCurrentUser(T currentUser);

    Map<Object, Object> getProperties();
    public void setProperties(Map<Object, Object> properties);
}
