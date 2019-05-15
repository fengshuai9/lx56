package com.jk.base;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FS001")
public class ReceiveSever {

    @RabbitHandler
    public void getMsg(String msg){

        System.out.println("消费者消费了："+msg);
    }



}
