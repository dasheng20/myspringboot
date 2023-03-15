package com.dongms.myspringboot.service.impl;

import com.dongms.myspringboot.entity.UserEntity;
import com.dongms.myspringboot.service.ICommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @title CommonUserServiceImpl
 * @Author: dongms
 * @Date: 2022/8/11
 */
@Service
public class CommonUserServiceImpl extends ICommonUserService {

    @Autowired
    UserServiceImpl userService ;

    @Override
    public List<UserEntity> findAllUser1 () {
        return userService.findAllUser();
    }
}
