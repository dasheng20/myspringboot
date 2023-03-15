package com.dongms.myspringboot.service.event;

import org.springframework.context.ApplicationListener;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title DemoListener
 * @Author: dongms
 * @Date: 2022/11/23
 */
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent (DemoEvent event) {
        String msg = event.getMessage();
        System.out.println("接收到的信息："+msg);
    }
}
