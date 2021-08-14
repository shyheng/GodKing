package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.UserMapper;
import com.shy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = TestService.class,version = "1.0.0",timeout = 15000)
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> select() {
        return userMapper.selectUser();
    }
}
