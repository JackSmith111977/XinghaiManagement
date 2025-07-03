package com.kei.service.Impl;

import com.kei.dao.ClassDao;
import com.kei.service.ClassService;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassServiceImpl implements ClassService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClassDao classDao = new ClassDao();

    @Override
    public void createClass() throws SQLException {
        System.out.println("\n=== 创建班级 ===");
        System.out.print("班级名称：");
        String name = scanner.nextLine();

        System.out.print("教师ID：");
        int teacherId = Integer.parseInt(scanner.nextLine());

        System.out.print("课程ID：");
        int courseId = Integer.parseInt(scanner.nextLine());

        System.out.print("上课时间：");
        String schedule = scanner.nextLine();

        classDao.createClass(name, teacherId, courseId, schedule);
    }

    @Override
    public void deleteClass() throws SQLException {
        System.out.println("\n=== 删除班级 ===");
        System.out.print("班级ID：");
        int classId = Integer.parseInt(scanner.nextLine());
        classDao.deleteClass(classId);
    }

    @Override
    public void updateClass() throws SQLException {
        System.out.println("\n=== 更新班级信息 ===");
        System.out.print("班级ID：");
        int classId = Integer.parseInt(scanner.nextLine());

        System.out.print("新班级名称(留空不修改)：");
        String name = scanner.nextLine();

        System.out.print("新教师ID(留空不修改)：");
        String teacherIdStr = scanner.nextLine();

        System.out.print("新课程ID(留空不修改)：");
        String courseIdStr = scanner.nextLine();

        System.out.print("新上课时间(留空不修改)：");
        String schedule = scanner.nextLine();

        classDao.updateClass(classId,
                name.isEmpty() ? null : name,
                teacherIdStr.isEmpty() ? null : Integer.parseInt(teacherIdStr),
                courseIdStr.isEmpty() ? null : Integer.parseInt(courseIdStr),
                schedule.isEmpty() ? null : schedule);
    }

    @Override
    public void addStudentToClass() throws SQLException {
        System.out.println("\n=== 添加学生到班级 ===");
        System.out.print("学生ID：");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("班级ID：");
        int classId = Integer.parseInt(scanner.nextLine());
        classDao.addStudentToClass(studentId, classId);
    }

    @Override
    public void removeStudentFromClass() throws SQLException {
        System.out.println("\n=== 从班级移除学生 ===");
        System.out.print("学生ID：");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("班级ID：");
        int classId = Integer.parseInt(scanner.nextLine());
        classDao.removeStudentFromClass(studentId, classId);
    }

    @Override
    public void getStudentsByClass() throws SQLException {
        System.out.println("\n=== 班级学生查询 ===");
        System.out.print("班级ID：");
        int classId = Integer.parseInt(scanner.nextLine());
        classDao.getStudentsByClass(classId);
    }

    @Override
    public void getClassesByTeacher() throws SQLException {
        System.out.println("\n=== 查询教师负责的班级 ===");
        System.out.print("教师ID：");
        int teacherId = Integer.parseInt(scanner.nextLine());
        classDao.getClassesByTeacher(teacherId);
    }
}