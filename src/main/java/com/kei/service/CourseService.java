package com.kei.service;

import java.sql.SQLException;

public interface CourseService {
    void addCourse() throws SQLException;
    void deleteCourse() throws SQLException;
    void updateCourse() throws SQLException;
    void getAllCourses() throws SQLException;
    void getCourseById() throws SQLException;
}