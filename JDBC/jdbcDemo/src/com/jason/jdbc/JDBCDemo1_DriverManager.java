package com.jason.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC Connection
 */

public class JDBCDemo1_DriverManager {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动 - MySQL 5以后可以省略
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        // URL：协议 + ip地址 ：端口号/数据库名称
        // String url = "jdbc:mysql://127.0.0.1:3306/sql_hr";

        // 如果数据库是本机地址并且端口为3306，可简化书写
//        String url = "jdbc:mysql:///sql_hr";

        // ?useSSL=false代表不使用安全连接方式
        String url = "jdbc:mysql:///sql_hr?useSSL=false";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义sql
        String sql = "update sql_hr.employees set salary = 119241 where employee_id = 76196";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 受影响的行数

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        stmt.close();;
        conn.close();


    }
}