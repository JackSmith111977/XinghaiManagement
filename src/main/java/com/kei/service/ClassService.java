package com.kei.service;

import java.sql.SQLException;

public interface ClassService {
    void createClass() throws SQLException;
    void deleteClass() throws SQLException;
    void updateClass() throws SQLException;
    void addStudentToClass() throws SQLException;
    void removeStudentFromClass() throws SQLException;
    void getStudentsByClass() throws SQLException;
    void getClassesByTeacher() throws SQLException;
}