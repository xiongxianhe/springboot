package com.jdz.controllers;

import com.jdz.beans.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UserController {

    /**
     * 方式一
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/user/login")
    public String login(String name, String pwd) {
        String res = "you input: name:" + name + "; pwd:" + pwd;
        return res;
    }

    @RequestMapping("/user/login2")
    public String login2(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        return "you input: name:" + name + "; pwd:" + pwd;
    }

    @RequestMapping("/user/login3")
    public String login3(User user) {
        return user.toString();
    }

    @RequestMapping(value = "/user/login4/{name}/{pwd}", method = RequestMethod.GET)
    public String login4(@PathVariable String name, @PathVariable String pwd) {
        return "you input: name:" + name + "; pwd:" + pwd;
    }

    @RequestMapping("/user/login5")
    public String login5(@RequestParam(value = "name", required = true) String name, @RequestParam("pwd") String pwd) {
        return "you input: name:" + name + "; pwd:" + pwd;
    }

    @RequestMapping("/user/login6")
    public String login6(@RequestParam Map<String, Object> params) {
        return "you input: name:" + params.get("name") + "; pwd:" + params.get("pwd");
    }

    @RequestMapping("/user/login7")
    public String login7(@RequestBody Map<String, Object> params) {
        return "you input: name:" + params.get("name") + "; pwd:" + params.get("pwd");
    }
}
