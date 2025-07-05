package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.ClassInfo;
import java.sql.*;

/**
 * 马璞
 */

public class ClassDao {
    // 创建班级
    public boolean createClass(String name, int teacherId, int courseId, String schedule) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO classes(name, teacher_id, course_id, schedule) VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, teacherId);
            pstmt.setInt(3, courseId);
            pstmt.setString(4, schedule);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("创建班级失败: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("关闭PreparedStatement失败: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("关闭Connection失败: " + e.getMessage());
            }
        }
    }

    // 删除班级
    public boolean deleteClass(int classId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "DELETE FROM classes WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, classId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("删除班级失败: " + e.getMessage());
            return false;
        } finally {
            closeResources(pstmt, conn);
        }
    }

    // 更新班级信息
    public boolean updateClass(int classId, String name, Integer teacherId, Integer courseId, String schedule) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            StringBuilder sql = new StringBuilder("UPDATE classes SET ");
            boolean needComma = false;

            if (name != null) {
                sql.append("name = ?");
                needComma = true;
            }
            if (teacherId != null) {
                if (needComma) sql.append(", ");
                sql.append("teacher_id = ?");
                needComma = true;
            }
            if (courseId != null) {
                if (needComma) sql.append(", ");
                sql.append("course_id = ?");
                needComma = true;
            }
            if (schedule != null) {
                if (needComma) sql.append(", ");
                sql.append("schedule = ?");
            }

            sql.append(" WHERE id = ?");

            pstmt = conn.prepareStatement(sql.toString());
            int paramIndex = 1;

            if (name != null) pstmt.setString(paramIndex++, name);
            if (teacherId != null) pstmt.setInt(paramIndex++, teacherId);
            if (courseId != null) pstmt.setInt(paramIndex++, courseId);
            if (schedule != null) pstmt.setString(paramIndex++, schedule);
            pstmt.setInt(paramIndex, classId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("更新班级失败: " + e.getMessage());
            return false;
        } finally {
            closeResources(pstmt, conn);
        }
    }

    // 添加学生到班级
    public boolean addStudentToClass(int studentId, int classId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO class_students(class_id, student_id) VALUES(?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, classId);
            pstmt.setInt(2, studentId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("添加学生到班级失败: " + e.getMessage());
            return false;
        } finally {
            closeResources(pstmt, conn);
        }
    }

    // 从班级移除学生
    public boolean removeStudentFromClass(int studentId, int classId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "DELETE FROM class_students WHERE class_id = ? AND student_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, classId);
            pstmt.setInt(2, studentId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("从班级移除学生失败: " + e.getMessage());
            return false;
        } finally {
            closeResources(pstmt, conn);
        }
    }

    // 获取班级学生列表
    public void getStudentsByClass(int classId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT s.id, s.name FROM student s JOIN class_students cs ON s.id = cs.student_id WHERE cs.class_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classId);
            rs = pstmt.executeQuery();

            System.out.println("=== 班级学生 ===");
            System.out.println("ID\t姓名");
            while (rs.next()) {
                System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("获取班级学生列表失败: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.err.println("关闭ResultSet失败: " + e.getMessage());
            }
            closeResources(pstmt, conn);
        }
    }

    // 获取教师负责的班级
    public void getClassesByTeacher(int teacherId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT id, name, course_id, schedule FROM classes WHERE teacher_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, teacherId);
            rs = pstmt.executeQuery();

            System.out.println("=== 教师负责的班级 ===");
            System.out.println("ID\t名称\t课程ID\t上课时间");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%d\t%s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("course_id"),
                        rs.getString("schedule"));
            }
        } catch (SQLException e) {
            System.err.println("获取教师班级列表失败: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.err.println("关闭ResultSet失败: " + e.getMessage());
            }
            closeResources(pstmt, conn);
        }
    }

    // 私有方法：关闭资源
    private void closeResources(Statement stmt, Connection conn) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            System.err.println("关闭Statement失败: " + e.getMessage());
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("关闭Connection失败: " + e.getMessage());
        }
    }
}