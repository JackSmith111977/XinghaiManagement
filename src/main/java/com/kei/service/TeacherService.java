package com.kei.service;

import java.sql.SQLException;
/**
 * 邱显煜
 */
public interface TeacherService {
    void addTeacher() throws SQLException;
    void deleteTeacherById() throws SQLException;
    void updateTeacher() throws SQLException;

    void queryTeacher() throws SQLException;
}
