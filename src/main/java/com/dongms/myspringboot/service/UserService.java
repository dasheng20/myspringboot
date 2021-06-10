package com.dongms.myspringboot.service;

import com.dongms.myspringboot.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUser();
}
