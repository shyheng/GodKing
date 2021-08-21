package com.shy.controller;

import com.alibaba.fastjson.JSON;
import com.shy.config.AddressUtils;
import com.shy.config.W24h;
import com.shy.model.HourWeather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {

    @RequestMapping("/ip")
    public String SelectIp(String ip){
        System.out.println(ip);
        if (ip == null){
            ip = AddressUtils.getCity(ip);
        }
        List<HourWeather> weatherList = W24h.w24h("e8e17d73c85f4019887d3faecfea4ada",ip);
        Map<String,Object> res = new HashMap<>();
        res.put("flag","yes");
        res.put("addr",ip);
        res.put("weatherList",weatherList);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/up_ip")
    public String SelectUpIp(String up_ip){
        System.out.println(up_ip);
        if (up_ip == null){
            up_ip = AddressUtils.getCity(up_ip);
        }
        List<HourWeather> weatherList = W24h.w24h("e8e17d73c85f4019887d3faecfea4ada",up_ip);
        Map<String,Object> res = new HashMap<>();
        res.put("flag","yes");
        res.put("addr",up_ip);
        res.put("weatherList",weatherList);
        return JSON.toJSONString(res);
    }
}
