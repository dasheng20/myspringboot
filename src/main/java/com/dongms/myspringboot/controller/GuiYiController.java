package com.dongms.myspringboot.controller;

import com.alibaba.excel.EasyExcel;
import com.dongms.myspringboot.entity.StudentEntity;
import com.dongms.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GuiYiController {

    @Autowired
    UserService userService;

    @GetMapping("student")
    public void test1( HttpServletResponse response){
        try {

            List<String> heads = new ArrayList<>();
            heads.add("wid");

            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            long startTime = System.currentTimeMillis();
            List<StudentEntity> list = data();
            System.out.println("query:"+ (System.currentTimeMillis()-startTime)/1000);

            long startTime1 = System.currentTimeMillis();
            EasyExcel.write(response.getOutputStream()).sheet().doWrite(list);
            System.out.println("genereate:" +(System.currentTimeMillis()-startTime1)/1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<StudentEntity> data(){
        return userService.findAllStu();
    }

}
