package com.dongms.myspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title TestController
 * @Author: dongms
 * @Date: 2022/11/14
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String printTest(){
        return "123121212";
    }

    @RequestMapping("/mysql")
    @ResponseBody
    public void testMysql(){
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.80.96.15:3306/nit?serverTimezone=UTC", "root", "nit_163");
            stmt = con.createStatement();
            String sql = "select * from test";
            ResultSet result = stmt.executeQuery(sql);

            ResultSetMetaData metaData = result.getMetaData();

            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                System.out.print(columnName + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
