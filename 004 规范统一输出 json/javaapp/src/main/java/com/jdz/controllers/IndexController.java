package com.jdz.controllers;

import com.jdz.beans.RtData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController extends BaseController {

    @RequestMapping("/index")
    public RtData<String> index() {
        return rtJson();
    }

    @RequestMapping("/list")
    public RtData<List<Integer>> list() {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < 10; i++) l.add(i);
        return rtJson(l);
    }
}
