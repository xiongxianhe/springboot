package com.jdz.controllers;

import com.jdz.beans.RESCODE;
import com.jdz.beans.ResData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController extends BaseController {

    public IndexController() {
        System.out.println("进入 IndexController " + this.getClass());
    }

    @RequestMapping("/")
    public ResData<String> index() {
        return rtJson();
    }

    @RequestMapping("/list")
    public ResData<List<Integer>> list() {
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++) l.add(i);
        return rtJson(l);
    }

    @RequestMapping("/err")
    public ResData<String> error() {
        return rtJson(RESCODE.ERR_INNER);
    }

    @RequestMapping("/map")
    public ResData<Map<String, String>> map() {
        Map<String, String> m = new HashMap<>();
        m.put("name", "中国");
        return rtJson(RESCODE.ERR_PARAM, m);
    }

}
