package com.kei.service;

import java.sql.SQLException;

public interface StudentService {
    public void addStudent() throws SQLException;
    public void deleteStudent() throws SQLException;
    public void updateStudent() throws SQLException;
    public void selectStudentByClassId() throws SQLException;

}
