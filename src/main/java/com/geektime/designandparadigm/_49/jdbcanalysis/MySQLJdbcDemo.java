package com.geektime.designandparadigm._49.jdbcanalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xschen
 * @see DriverManager#getConnection(String)
 * @see com.mysql.cj.jdbc.Driver
 *
 */
public class MySQLJdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 加载 com.mysql.cj.jdbc.Driver 这个类
        // 2. 执行其 static 静态代码块, 将MySQL Driver 注册到DriverManager中
        // java.sql.DriverManager.registerDriver(new Driver());
        //Class.forName("com.mysql.cj.jdbc.Driver"); // 由于 Java SPI 机制的引入，这段代码可以不用显式执行。
        String url = "jdbc:mysql://119.45.56.227:3306/test_db?user=root&password=123456";
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("连接成功：" + connection.toString());
        } catch (SQLException throwables) {
            System.out.println("连接失败");
        }

    }
}
