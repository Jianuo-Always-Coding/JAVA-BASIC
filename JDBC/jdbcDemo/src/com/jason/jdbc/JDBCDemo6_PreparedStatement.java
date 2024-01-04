package com.jason.jdbc;

import org.junit.Test;

import java.sql.*;


/**
 * API 详解：PreparedStatement
 */
public class JDBCDemo6_PreparedStatement {
    @Test
    public void testPreparedStatement() throws Exception{
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms?useSSL=false";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 接收用户输入的用户名和密码
        String name = "xiaoming";
        String pwd = "' or '1' = '1";
        String sql = "select * from lms.users where username = ? and password = ?";

        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        // 5. 执行sql
        ResultSet rs = pstmt.executeQuery();

        // 6. 判断是否登陆成功
        if  (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        // 7. 释放资源
        rs.close();
        pstmt.close();;
        conn.close();
    }

    /**
     * PreparedStatement 原理详解
     */
    @Test
    public void testPreparedStatement2() throws Exception{
        // 2. 获取连接
        // useServerPrepStmts=true 开启预编译
        String url = "jdbc:mysql://127.0.0.1:3306/lms?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 接收用户输入的用户名和密码
        String name = "xiaoming";
        String pwd = "' or '1' = '1";
        String sql = "select * from lms.users where username = ? and password = ?";

        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql); // 预编译开始

        // 设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        // 5. 执行sql
        ResultSet rs = pstmt.executeQuery();

        // 6. 判断是否登陆成功
        if  (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        // 7. 释放资源
        rs.close();
        pstmt.close();;
        conn.close();
    }
}
