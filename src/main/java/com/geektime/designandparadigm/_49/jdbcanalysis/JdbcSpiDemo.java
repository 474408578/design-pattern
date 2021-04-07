package com.geektime.designandparadigm._49.jdbcanalysis;

/**
 * JDBC SPI 分析示例
 * @author xschen
 *
 *
 */
public class JdbcSpiDemo {

    /**
     * 1. 如何为 {@link java.sql.Driver} 找到具体的实现？
     *    文件：具体包的 classpath:/META-INF/services/java.sql.Driver 文件
     *    文件中写的是 java.sql.Driver 的实现类： com.mysql.cj.jdbc.Driver
     */

    /**
     * 2. SPI 如何加载这个类
     * 当执行 DriverManager.getConnection时，会触发 DriverManager类的加载，执行其静态代码块，
     * 代码块中的方法 loadInitialDrivers() 会触发 ServiceLoader.load(Driver.class)
     * {@link java.util.ServiceLoader }
     */

}
