package com.dongms.myspringboot.service;

import com.dongms.myspringboot.entity.UserEntity;
import com.dongms.myspringboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title ICommonUserService
 * @Author: dongms
 * @Date: 2022/8/11
 */
public abstract class ICommonUserService {

    @Autowired
    UserServiceImpl userService ;

    public List<UserEntity> findAllUser (){
       return userService.findAllUser();
    }

    public abstract List<UserEntity> findAllUser1 ();
}
