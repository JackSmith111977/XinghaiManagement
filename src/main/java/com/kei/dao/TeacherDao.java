package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeacherDao {

    public void addTeacher(Teacher teacher) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取SQL执行语句
        String sql = "insert into teacher(name,class_id,begin_time,end_time,fee) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, teacher.getName());
        preparedStatement.setInt(2, teacher.getClassId());
        preparedStatement.setObject(3, teacher.getBeginTime());
        preparedStatement.setObject(4, teacher.getEndTime());
        preparedStatement.setDouble(5, teacher.getFee());

        // 3. 执行sql
        int update = preparedStatement.executeUpdate();
        // 4. 处理结果
        System.out.println(update > 0 ? "添加成功" : "添加失败");
        // 5. 释放资源
        preparedStatement.close();
        connection.close();

    }

    public void deleteTeacher(int id) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "delete from teacher where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        // 3. 执行语句
        int result = preparedStatement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "删除成功" : "删除失败");
        // 5. 释放资源
        preparedStatement.close();
        connection.close();

    }

    public void updateTeacherName(int id, String name) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "update teacher set name = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        // 3. 执行语句
        int result = preparedStatement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        preparedStatement.close();
        connection.close();
    }

    public void updateTeacherClassId(int id, int classId) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "update teacher set class_id = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, classId);
        statement.setInt(2, id);
        // 3. 执行语句
        int result = statement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    public void updateTeacherBeginTime(int id, LocalDate beginTime) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "update teacher set begin_time = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, beginTime);
        statement.setInt(2, id);
        // 3. 执行语句
        int result = statement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    public void updateTeacherEndTime(int id, LocalDate endTime) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "update teacher set end_time = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, endTime);
        statement.setInt(2, id);
        // 3. 执行语句
        int result = statement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    public void updateTeacherFee(int id, double fee) throws SQLException {
        // 1. 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2. 创建语句
        String sql = "update teacher set fee = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, fee);
        statement.setInt(2, id);
        // 3. 执行语句
        int result = statement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        statement.close();
        connection.close();
    }
}
