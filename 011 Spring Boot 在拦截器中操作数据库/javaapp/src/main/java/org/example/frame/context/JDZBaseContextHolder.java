/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/16 12:30
 * Desc:
 */
package org.example.frame.context;

public class JDZBaseContextHolder {
    private static final ThreadLocal<JDZContext> contextHolder = new ThreadLocal<>();

    public JDZBaseContextHolder() {

    }

    public static void setContext(JDZContext context) {
        contextHolder.set(context);
    }

    public static JDZContext getContext() {
        JDZContext obj = contextHolder.get();
        if(obj == null) {
            obj = new JDZContext();
            setContext(obj);
        }
        return obj;
    }

    public static void removeContext() {
        contextHolder.remove();
    }
}
