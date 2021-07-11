package com.dongms.myspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
@Slf4j
public class cpuHighTestController {

    private boolean flag = false;

    @RequestMapping("/test")
    public void start(){
        log.info("start test");
        while (!flag){

        }
    }
}
