package com.dongms.myspringboot.service.impl;

import com.dongms.myspringboot.entity.StudentEntity;
import com.dongms.myspringboot.entity.UserEntity;
import com.dongms.myspringboot.mapper.UserMapper;
import com.dongms.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserEntity> findAllUser() {
        return mapper.findAllUser();
    }

    @Override
    public List<StudentEntity> findAllStu() {
        return mapper.findAllStu();
    }
}
