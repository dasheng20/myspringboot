package com.dongms.myspringboot.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class RunClass2 implements Runnable{

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Override
    public void run() {
        System.out.println("run2");
//      while (true){
//          try {
//              Thread.sleep(1000);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//          System.out.println("activecount:"+threadPoolTaskExecutor.getActiveCount());
//      }
    }
}
