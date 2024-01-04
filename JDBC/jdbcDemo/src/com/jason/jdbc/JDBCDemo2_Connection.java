package com.jason.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC Connection
 */

public class JDBCDemo2_Connection {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义sql
        String sql1 = "update lms.user set password = 111 where id = 1";
        String sql2 = "update lms.user set password = 222 where id = 2";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 开启事务 + （如果有异常事务回滚） + 提交事务

        try {
            //开启事务
            conn.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1); // 受影响的行数
            System.out.println(count1);

            int a = 5 / 0;

            int count2 = stmt.executeUpdate(sql2); // 受影响的行数
            System.out.println(count2);

            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        // 7. 释放资源
        stmt.close();;
        conn.close();

    }
}