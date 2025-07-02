package com.dongms.myspringboot.entity;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
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
 * @title BlobTypeHandler
 * @Author: dongms
 * @Date: 2022/9/27
 */
public class BlobTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    String parameter, JdbcType jdbcType) throws SQLException {
        //声明一个输入流对象
        ByteArrayInputStream bis;
        try {
            //把字符串转为字节流
            bis = new ByteArrayInputStream(parameter.getBytes("utf-8"));
        } catch ( UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
        ps.setBinaryStream(i, bis, parameter.length());
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Blob blob = (Blob) rs.getBlob(columnName);
        byte[] returnValue = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            //将取出的流对象转为utf-8的字符串对象
            return new String(returnValue, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
    }

    @Override
    public String getNullableResult (ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult (CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
