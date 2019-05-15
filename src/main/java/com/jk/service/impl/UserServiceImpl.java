package com.jk.service.impl;


import com.jk.mapper.UserMapper;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)//事务控制
    public List<UserBean> queryUser() {
        return userMapper.queryUser();
    }


    @Autowired
    private AmqpTemplate amqpTemplate;

    //发送消息
    @Override
    public void sendMsg(String msg) {
        amqpTemplate.convertAndSend("FS001",msg);
    }
}
