package com.dongms.myspringboot.controller;

import com.dongms.myspringboot.mapper.CommonMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title CommonMapperController
 * @Author: dongms
 * @Date: 2022/9/26
 */
@RestController
@RequestMapping("/common")
@Setter
public class CommonMapperController {

    @Resource
    private CommonMapper commonMapper;

    @RequestMapping("/findMap")
    public Object getPerson(){
        Map<String,Object> result = commonMapper.findMap();
        return result;
    }
}
