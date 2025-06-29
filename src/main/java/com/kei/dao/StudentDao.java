package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    public void addStudent(Student student) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取SQL执行语句
        String sql = "insert into student(name,phone,class_id,course_id) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getPhone());
        preparedStatement.setInt(3, student.getClassId());
        preparedStatement.setInt(4, student.getCourseId());

        // 3.执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();

        // 4.解析结果集
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");

        // 5.释放资源
        preparedStatement.close();
        connection.close();
    }

    public void deleteStudent(int id) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();

        // 2.获取SQL执行语句
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        // 3.执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();

        // 4.解析结果集
        System.out.println(result > 0 ? "删除成功！" : "删除失败！");

        // 5.释放资源
        preparedStatement.close();
        connection.close();


    }

    public void updateStudentName(int id, String name) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2.获取SQL执行语句
        String sql = "update student set name = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        // 3.执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();
        // 4.解析结果集
        System.out.println(result > 0 ? "更新成功！" : "更新失败！");
        // 5.释放资源
        preparedStatement.close();
        connection.close();

    }

    public void updateStudentPhone(int id, String phone) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2.获取SQL执行语句
        String sql = "update student set phone = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, phone);
        preparedStatement.setInt(2, id);
        // 3.执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();
        // 4.解析结果集
        System.out.println(result > 0 ? "更新成功！" : "更新失败！");
        // 5.释放资源
        preparedStatement.close();
        connection.close();
    }

    public void updateStudentClassId(int id, int classId) throws SQLException {
        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 2.创建SQL语句
        String sql = "update student set class_id = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, classId);
        preparedStatement.setInt(2, id);
        // 3.执行SQL语句, 返回受影响的行数
        int result = preparedStatement.executeUpdate();
        // 4.处理结果
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5.释放资源
        preparedStatement.close();
        connection.close();

    }

    public void updateStudentCourseId(int id, int courseId) throws SQLException {
        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 2.准备SQL语句
        String sql = "update student set course_id = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, courseId);
        preparedStatement.setInt(2, id);
        // 3.执行SQL语句
        int update = preparedStatement.executeUpdate();
        // 4.处理结果
        System.out.println(update > 0 ? "更新成功" : "更新失败");
        // 5.释放资源
        preparedStatement.close();
        connection.close();
    }

    public void selectStudentByClassId(int classId) throws SQLException {
        // 1.获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 2.准备SQL语句
        String sql = "SELECT * FROM student WHERE class_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, classId);
        // 3.执行SQL语句,获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        // 4.处理结果集
        while (resultSet.next()) {
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
        preparedStatement.close();
        connection.close();
        resultSet.close();
    }
}
