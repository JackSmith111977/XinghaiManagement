package com.kei.controller;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 邱显煜
 */

public class MainController {
    private final PianoController pianoController = new PianoController();
    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();
    private final CustomerController customerController = new CustomerController();
    private final CourseController courseController = new CourseController();
    private final ClassController classController = new ClassController();
    private final Scanner scanner = new Scanner(System.in);

    // 星海琴行主管理系统入口
    public void start() throws SQLException {
        System.out.println("===========================");
        System.out.println("欢迎来到星海琴行主管理系统 v0.1");
        System.out.println("===========================");

        boolean running = true;
        while (running) {
            showMenu();
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    pianoController.start(); // 琴管理系统
                    break;
                case 2:
                    teacherController.start(); // 教师管理系统
                    break;
                case 3:
                    classController.start(); // 班级管理系统
                    break;
                case 4:
                    customerController.start(); // 顾客管理系统
                    break;
                case 5:
                    courseController.start(); // 课程管理系统
                    break;
                case 6:
                    studentController.start(); // 学生管理系统
                    break;
                case 7:
                    System.out.println("退出系统");
                    running = false;
                    break;
                default:
                    System.out.println("无效输入，请重新输入");
            }
        }
        // 关闭输入流
        scanner.close();
    }

    // 菜单
    public void showMenu() {
        System.out.println("1. 琴管理系统");
        System.out.println("2. 教师管理系统");
        System.out.println("3. 班级管理系统");
        System.out.println("4. 顾客管理系统");
        System.out.println("5. 课程管理系统");
        System.out.println("6. 学生管理系统");
        System.out.println("7. 退出系统");
    }
}