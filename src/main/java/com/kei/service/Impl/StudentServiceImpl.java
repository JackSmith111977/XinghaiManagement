package com.kei.service.Impl;

import com.kei.dao.StudentDao;
import com.kei.pojo.Student;
import com.kei.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDao studentDao = new StudentDao();


    @Override
    public void addStudent() throws SQLException {
        System.out.println("请输入学生的姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学生的手机号：");
        String phone = scanner.nextLine();
        System.out.println("请输入学生的班级ID：");
        int classId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入学生的课程ID：");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(null, name, phone, classId, courseId);
        studentDao.addStudent(student);

    }

    @Override
    public void deleteStudent() throws SQLException {
        System.out.println("请输入学生的ID：");
        int id = scanner.nextInt();
        // 手动清空因nextInt()无法读取回车而产生缓冲区换行问题
        scanner.nextLine();
        studentDao.deleteStudent(id);

    }

    @Override
    public void updateStudent() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("请输入学生的ID，或输入0退出学生信息修改系统：");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                running = false;

                break;
            }
            System.out.println("请输入要修改的信息：");
            System.out.println("1.修改姓名");
            System.out.println("2.修改手机号");
            System.out.println("3.修改班级ID");
            System.out.println("4.修改课程ID");
            System.out.println("5.取消修改");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("请输入学生姓名");
                    String name = scanner.next();
                    studentDao.updateStudentName(id,name);
                    break;
                case 2:
                    System.out.println("请输入学生手机号");
                    String phone = scanner.next();
                    studentDao.updateStudentPhone(id,phone);
                    break;
                case 3:
                    System.out.println("请输入学生班级ID");
                    int classId = scanner.nextInt();
                    scanner.nextLine();
                    studentDao.updateStudentClassId(id,classId);
                    break;
                case 4:
                    System.out.println("请输入学生课程ID");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();
                    studentDao.updateStudentCourseId(id,courseId);
                    break;
                case 5:
                    System.out.println("取消修改,返回学生管理系统");
                    running = false;

                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }

    }

    @Override
    public void selectStudentByClassId() throws SQLException {
        System.out.println("请输入班级ID：");
        int classId = scanner.nextInt();
        scanner.nextLine();
        studentDao.selectStudentByClassId(classId);
    }
}
