package com.dongms.myspringboot;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title Test
 * @Author: dms
 * @Date: 2023/7/4
 */
@SpringBootTest
public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(IdWorker.getIdStr());
    }
}
