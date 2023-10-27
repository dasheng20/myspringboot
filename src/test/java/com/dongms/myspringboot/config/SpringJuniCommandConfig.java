package com.dongms.myspringboot.config;

import com.dongms.myspringboot.util.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title SpringJuniCommandConfig
 * @Author: dongms
 * @Date: 2023/9/15
 */
@MapperScan(basePackages = {})
@ComponentScan(basePackages = {"com.dongms.myspringboot.util"},basePackageClasses = { RedisUtil.class })
@Import({ RedisConfiguration.class, RestTemplate.class })
public class SpringJuniCommandConfig {
}
