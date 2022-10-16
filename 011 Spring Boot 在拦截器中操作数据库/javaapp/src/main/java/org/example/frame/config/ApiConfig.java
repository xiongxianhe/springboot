/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 20:40
 * Desc:
 */
package org.example.frame.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiConfig {
    public static Map<String, Object> notNeedCheckToken2 = new HashMap<String, Object>(){{
        // api
        put("/v2/api/login", 1);

        // backend
        put("/v2/admin/login", 1);
    }};

    public static List<String> notNeedCheckToken3 = new ArrayList<String>(){{
        // api
        add("/v2/api/login");

        // backend
        add("/v2/admin/login");
    }};


    public static String[] notNeedCheckToken = {

            // api
            "/v2/api/user/login",

            // backend
            "/v2/admin/user/login"
    };
}
