package com.shy.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.shy.model.HourWeather;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class W24h {
    public static List<HourWeather> w24h(String appCode, String area) {

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = (new Request.Builder()).get().url("http://saweather.market.alicloudapi.com/hour24?area=" + area).header("Authorization", "APPCODE " + appCode).build();
            Call call = client.newCall(request);
            Response response = call.execute();
            Gson gson = (new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            String resBody = response.body().string();
            Map result = (Map)gson.fromJson(resBody, (new TypeToken<Map>() {
            }).getType());
            Map<String,Object> map = (Map<String, Object>) result.get("showapi_res_body");
            List<Map<String,String>> maps = (List<Map<String, String>>) map.get("hourList");
            List<HourWeather> hourWeathers = new ArrayList<>();
            for (int i = 0; i < maps.size(); i++) {
                HourWeather hourWeather = new HourWeather();
                hourWeather.setHour(maps.get(i).get("time").substring(8, 10));
                hourWeather.setTemperature(maps.get(i).get("temperature"));
                hourWeather.setWeather(maps.get(i).get("weather"));
                hourWeathers.add(hourWeather);
            }

            return hourWeathers;
        } catch (Exception var15) {
            throw new RuntimeException(var15);
        }
    }
}
