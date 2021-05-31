package com.dongms.myspringboot.threadpool;

public class RunClass implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(111111);
    }
}
