package com.jk.base;

import com.jk.service.UserService;

/*第一种
* 当某个类 实现了Runnable接口，重写了run方法，这个类就变成了线程类
* */
public class ThreadTest implements Runnable {
    private UserService userService;
    private String msg;
    public ThreadTest() {

    }

    public ThreadTest(UserService userService, String msg) {
        this.userService = userService;
        this.msg = msg;
    }

    @Override
    public void run() {
        //当前线程需要执行的任务   线程体

        userService.sendMsg(msg);
    }
}

//第二种
/*public class ThreadTest extends Thread {

    @Override
    public void run() {

        super.run();
    }
}*/


//第三种
/*public class ThreadTest implements Callable {


    @Override
    public Object call() throws Exception {
        return null;
    }
}*/


