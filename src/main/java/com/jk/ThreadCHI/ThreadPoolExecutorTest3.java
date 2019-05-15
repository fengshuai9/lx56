package com.jk.ThreadCHI;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest3 {


    public static void main(String[] args) {

        //创建一个定长延时线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);


        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
