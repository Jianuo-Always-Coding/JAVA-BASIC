package com.jason.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 用户登陆
 */
public class JDBCDemo5_UserLogin {
    @Test
    public void testUserLogin() throws Exception{
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms?useSSL=false";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 接收用户输入的用户名和密码
        String name = "xiaoming";
        String pwd = "123";
        String sql = "select * from lms.users where username = '"+name+"' and password = '"+pwd+"'";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 6. 判断是否登陆成功
        if  (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        // 7. 释放资源
        rs.close();
        stmt.close();;
        conn.close();
    }

    /**
     * 演示SQL注入
     */
    @Test
    public void testUserLoginInjection() throws Exception{
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms?useSSL=false";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 接收用户输入的用户名和密码
        String name = "12sawffds";
        String pwd = "' or '1' = '1";
        String sql = "select * from lms.users where username = '"+name+"' and password = '"+pwd+"'";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 6. 判断是否登陆成功
        if  (rs.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        // 7. 释放资源
        rs.close();
        stmt.close();;
        conn.close();
    }
}
