package com.kei.jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * JDBC工具类
 * 获取连接，返回连接
 */
public class JDBCUtils {
    private static final String url = "jdbc:mysql://localhost:3306/db_xinghai";
    private static final String user = "root";
    private static final String password = "114514";

    // 静态代码块，加载驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("找不到数据库驱动",e);
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
