package com.dongms.myspringboot.threadpool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadRunTest {

    @Autowired
    private ThreadRun threadRun;

    @Test
    void run() {
        threadRun.run();
    }
}