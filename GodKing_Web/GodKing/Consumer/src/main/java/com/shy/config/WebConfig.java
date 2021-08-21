package com.shy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;

//配置
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        InetAddress inetAddr= null;
        try {
            inetAddr = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip = inetAddr.getHostAddress();
        System.out.println(ip);
        registry.addMapping("/**")
                .allowedOrigins("http://"+"120.77.255.179"+":8035","null")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
