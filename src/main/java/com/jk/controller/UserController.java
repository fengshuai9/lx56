package com.jk.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.jk.base.RabbitConfig;
import com.jk.base.ThreadTest;
import com.jk.model.UserBeanMd;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController  //@Controller + @responseBody  = @RestController
@RequestMapping(value = "user",produces="application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;





    @RequestMapping("tomain")
    public String tomain(){
        System.out.println("hahahsssssssssssssh");
        return "main";
    }


    @RequestMapping(value = "/index/{id}/{age}", method = RequestMethod.GET)
    public String toIndex(@PathVariable Integer id,@PathVariable Integer age){
        System.out.println(id);
        return "";
    }

    @GetMapping(value = "/ceshi2/{id}/{name}",produces="application/json;charset=UTF-8")
    public String ceshi(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+"==="+name);
        return name;
    }

    //查询！！
    @RequestMapping(value = "/queryUser")
    public List<UserBean> queryUser(){
        //分页  当前页，煤业几条
        PageHelper.startPage(1,3);

        List<UserBean> list=userService.queryUser();
        String userlist = JSON.toJSONString(list);

        //缓存到rendis里面
        redisTemplate.opsForValue().set("userkey",userlist);
        return list;
    }


    //新增数据  mongodb数据库
    @GetMapping(value = "/addUser")
    public void addUser(){
        UserBeanMd userBeanMd = new UserBeanMd();
        userBeanMd.setName("我是你爸爸");
        userBeanMd.setAsd("对的");
        mongoTemplate.insert(userBeanMd);
    }



    //发送消息
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    @GetMapping(value = "/sendMsg")
    public String  sendMsg(){

        //第一种
        //amqpTemplate.convertAndSend("FS001","哈哈");
        String msg="7777";
        cachedThreadPool.execute(new ThreadTest(userService,msg));


        //userService.sendMsg(msg);
        //rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,"第二种发送！~");

        return "okk";

    }






}
