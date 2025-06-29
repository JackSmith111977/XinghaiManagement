package com.kei;

import com.kei.pojo.Student;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCTest {

    /**
     * JDBC 入门程序
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");


        // 2.获取连接(URL = jdbc:数据源名字://端口号/要使用的数据库)
        String url = "jdbc:mysql://localhost:3306/db_xinghai";
        String user = "root";
        String password = "114514";
        Connection connection = DriverManager.getConnection(url, user, password);


        // 3.获取sql语句的执行对象
        Statement statement = connection.createStatement();


        // 4.执行sql语句，得到返回结果
        int i = statement.executeUpdate("update student set name = '白白猫' where id = 1");
        System.out.println("sql执行受到影响的行数：" + i);


        // 5.释放资源
        statement.close();
        connection.close();

    }

    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");


        // 2.获取连接(URL = jdbc:数据源名字://端口号/要使用的数据库)
        String url = "jdbc:mysql://localhost:3306/db_xinghai";
        String user = "root";
        String password = "114514";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3.获取sql语句的执行对象
        // 预编译sql
        String sql = "select id,name,phone,class_id,course_id from student where id = ?";
        // 预编译执行对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "1");

        // 封装查询的结果
        ResultSet resultSet = statement.executeQuery();

        // 4.处理结果集
        while (resultSet.next()){
            Student student = new Student(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("phone"),
                resultSet.getInt("class_id"),
                resultSet.getInt("course_id")
            );
            System.out.println(student);
        }

        // 5.释放资源
        resultSet.close();
        statement.close();
        connection.close();

    }







}
