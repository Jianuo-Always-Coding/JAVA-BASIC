package com.jason.jdbc;

import com.jason.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * JDBC API 详解：ResultSet
 */

public class JDBCDemo4_ResultSet {
    /**
     * 执行DQL语句
     * @throws Exception
     */
    @Test
    public void testResultSet1() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from lms.user";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 6. 处理结果
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()) {
            // 6.2 获取数据 getXxx()
//            int id = rs.getInt(1);
//            String userName = rs.getString(2);
//            String passWord = rs.getString(3);
//            int salary = rs.getInt(4);

            int id = rs.getInt("id");
            String nickname = rs.getString("nickname");
            String phoneNumber = rs.getString("phone_number");
            int salary = rs.getInt("salary");

            System.out.println(id + "/" + nickname + "/" + phoneNumber + "/" + salary);
            System.out.println("-----------------------");
        }

        // 7. 释放资源
        rs.close();
        stmt.close();;
        conn.close();
    }


    /**
     * 查询user账户表数据，封装为Account对象中，并且储存到ArrayList集合中
     * 1. 定义实体类 Account
     * 2. 查询数据，封装到Account对象中
     * 3. 将Account对象存入ArrayList集合中
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/lms";
        String username = "root";
        String password = "yyqx123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from lms.user";

        // 4. 获取执行sql的对象statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql); // 受影响的行数

        // 创建集合
        List<Account> list = new ArrayList<>();

        // 6. 处理结果
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()) {
            Account account = new Account();
//            int id = rs.getInt("id");
//            String nickname = rs.getString("nickname");
//            String phoneNumber = rs.getString("phone_number");
//            int salary = rs.getInt("salary");

            int id = rs.getInt(1);
            String nickname = rs.getString(2);
            String phoneNumber = rs.getString(3);
            int salary = rs.getInt(4);
            System.out.println(salary);

            // 给对象赋值
            account.setId(id);
            account.setNickname(nickname);
            account.setPhoneNumber(phoneNumber);
            account.setSalary(salary);

            // 创建出的对象加入list中
            list.add(account);
        }

        System.out.println(list.toString());

        // 7. 释放资源
        rs.close();
        stmt.close();;
        conn.close();
    }

}
