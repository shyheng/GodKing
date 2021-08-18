package com.shy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.shy.service.TestService;
import com.shy.service.WorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkController {
    @Reference(interfaceClass = WorkService.class, version = "1.0.0", check = false, timeout = 15000)
    private WorkService workService;

    @RequestMapping("/work")
    public String work(){
        Map<String,Object> res = new HashMap<>();
        res.put("flag","yes");
        res.put("work",workService.selectWork());
        return JSON.toJSONString(res);
    }
}
