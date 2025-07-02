package com.dongms.myspringboot.controller;

import com.dongms.myspringboot.entity.AjaxResult;
import com.dongms.myspringboot.entity.UserEntity;
import com.dongms.myspringboot.service.ICommonUserService;
import com.dongms.myspringboot.service.UserService;
import com.dongms.myspringboot.service.impl.CommonUserServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Setter
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ICommonUserService commonUserService;

    @RequestMapping("/findUser")
    public Result findUser(){
        Result result = new Result();
        result.setData(userService.findAllUser());
        result.setCode("200");
        result.setMsg("success");
        return result ;
    }

    @RequestMapping("/findUserAll")
    public AjaxResult findUserAll(){

       return AjaxResult.success(commonUserService.findAllUser());

    }

    @RequestMapping("/findUser1")
    public List<UserEntity> findUser1(){
        return commonUserService.findAllUser1();
    }


}
