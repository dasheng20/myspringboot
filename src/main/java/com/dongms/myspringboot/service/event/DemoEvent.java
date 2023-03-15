package com.dongms.myspringboot.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title DemoEvent
 * @Author: dongms
 * @Date: 2022/11/23
 */
public class DemoEvent extends ApplicationEvent {
    private String message;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DemoEvent (Object source, String message) {
        super(source);
        this.message = message;
    }


    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
