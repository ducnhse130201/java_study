package com.example.chapter11.service.impl;

import com.example.chapter11.dao.UserMapper;
import com.example.chapter11.domain.User;
import com.example.chapter11.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User> implements IService<User> {

    @Autowired
    private UserMapper userMapper;

}
