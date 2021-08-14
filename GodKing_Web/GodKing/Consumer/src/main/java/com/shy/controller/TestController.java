package com.shy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.shy.model.User;
import com.shy.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Reference(interfaceClass = TestService.class, version = "1.0.0", check = false, timeout = 15000)
    private TestService testService;

    @RequestMapping("/shy")
    public String test(String shy){
        System.out.println(shy);
        Map<String,Object> res = new HashMap<>();
        res.put("flag","yes");
        res.put("shy",testService.select());
        return JSON.toJSONString(res);
    }
}
