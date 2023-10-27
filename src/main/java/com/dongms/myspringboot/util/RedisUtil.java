package com.dongms.myspringboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title RedisUtil
 * @Author: dongms
 * @Date: 2023/9/15
 */
@Slf4j
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public Boolean setCache(String key, String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch ( Exception e ){
            log.error("添加缓存失败",e);
            return false;
        }
    }

    public String getCache(String key){
        try {
            return ( String ) redisTemplate.opsForValue().get(key);
        }catch ( Exception e ){
            log.error("添加缓存失败",e);
            return null;
        }
    }
}
