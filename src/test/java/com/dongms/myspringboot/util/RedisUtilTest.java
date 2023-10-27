package com.dongms.myspringboot.util;

import com.dongms.myspringboot.config.SpringJuniCommandConfig;
import com.dongms.myspringboot.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title RedisUtilTest
 * @Author: dongms
 * @Date: 2023/9/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJuniCommandConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void setCache () {

        userService.findAllUser();

        Boolean result = redisUtil.setCache("name","张三");
        Assertions.assertTrue(result);
    }

    @Test
    public void getCache () {
    }
}
