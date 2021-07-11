package com.dongms.myspringboot.mapper;

import com.dongms.myspringboot.entity.StudentEntity;
import com.dongms.myspringboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> findAllUser();

    List<StudentEntity> findAllStu();

}
