package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Course;
import java.sql.*;
import java.math.BigDecimal;

/**
 * 马璞
 */

public class CourseDao {
    public void addCourse(Course course) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "INSERT INTO courses(name, instrument_type, price, lesson_count) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, course.getName());
        pstmt.setString(2, course.getInstrumentType());
        pstmt.setBigDecimal(3, course.getPrice());
        pstmt.setInt(4, course.getLessonCount());

        int result = pstmt.executeUpdate();
        System.out.println(result > 0 ? "课程添加成功！" : "课程添加失败！");

        pstmt.close();
        conn.close();
    }

    public void deleteCourse(int id) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "DELETE FROM courses WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        int result = pstmt.executeUpdate();
        System.out.println(result > 0 ? "课程删除成功！" : "课程删除失败！");

        pstmt.close();
        conn.close();
    }

    public void updateCourse(Course course) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "UPDATE courses SET name = ?, instrument_type = ?, price = ?, lesson_count = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, course.getName());
        pstmt.setString(2, course.getInstrumentType());
        pstmt.setBigDecimal(3, course.getPrice());
        pstmt.setInt(4, course.getLessonCount());
        pstmt.setInt(5, course.getId());

        int result = pstmt.executeUpdate();
        System.out.println(result > 0 ? "课程更新成功！" : "课程更新失败！");

        pstmt.close();
        conn.close();
    }

    public void getAllCourses() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "SELECT * FROM courses";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("=== 所有课程 ===");
        System.out.println("ID\t名称\t\t类型\t价格\t课次");
        while (rs.next()) {
            System.out.printf("%d\t%-10s\t%-6s\t%.2f\t%d\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("instrument_type"),
                    rs.getBigDecimal("price"),
                    rs.getInt("lesson_count"));
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    public Course getCourseById(int id) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "SELECT * FROM courses WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        Course course = null;
        if (rs.next()) {
            course = new Course();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            course.setInstrumentType(rs.getString("instrument_type"));
            course.setPrice(rs.getBigDecimal("price"));
            course.setLessonCount(rs.getInt("lesson_count"));
        }

        rs.close();
        pstmt.close();
        conn.close();
        return course;
    }
}