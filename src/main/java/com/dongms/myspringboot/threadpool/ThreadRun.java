package com.dongms.myspringboot.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadRun {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void run (){

        threadPoolTaskExecutor.submit(new RunClass2());
        for(int i=0;i<30;i++){
            threadPoolTaskExecutor.submit(new RunClass());
            System.out.println("count:"+threadPoolTaskExecutor.getActiveCount());
        }


    }
}
