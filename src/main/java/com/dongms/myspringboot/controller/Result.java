package com.dongms.myspringboot.controller;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title Result
 * @Author: dms
 * @Date: 2023/6/25
 */
@Data
public class Result implements Serializable {

    private Object data;
    private String code;
    private String msg;
}
