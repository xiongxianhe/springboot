/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 16:09
 * Desc:
 */
package org.example.controller;

import org.example.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    JWTUtils j;

    @RequestMapping("/")
    public String index() {

        String t  = j.generate(new HashMap<String, Object>(){{put("abc", "123");}});
        return t;
    }

    @RequestMapping("/t")
    public Map<String, Object> p(String token) {

        Map<String, Object> l = j.parse(token);
        System.out.println(l);
        return l;
    }
}
