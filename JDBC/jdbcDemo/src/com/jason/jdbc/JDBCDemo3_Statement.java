package com.jason.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC API 详解：Statement
 */

public class JDBCDemo3_Statement {
    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义sql
        String sql = "update lms.user set password = 123456 where id = 3";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 受影响的行数

        // 6. 处理结果
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        // 7. 释放资源
        stmt.close();;
        conn.close();
    }

    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义sql
        String sql = "drop database db1"; // drop数据库返回0，不报异常即为ok

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 受影响的行数

        // 7. 释放资源
        stmt.close();;
        conn.close();
    }

}
