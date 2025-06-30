package com.kei.controller;

import com.kei.service.Impl.TeacherServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class TeacherController {
    private Scanner scanner = new Scanner(System.in);
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();

    public void start() throws SQLException {
        System.out.println("欢迎来到教师管理系统");
        boolean running = true;
        while (running){
            System.out.println("1.添加教师");
            System.out.println("2.删除教师");
            System.out.println("3.修改教师");
            System.out.println("4.查询教师");
            System.out.println("5.退出系统");
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    teacherService.addTeacher();
                    break;
                case 2:
                    teacherService.deleteTeacherById();
                    break;
                case 3:
                    teacherService.updateTeacher();
                    break;
                case 4:
                    teacherService.queryTeacher();
                    break;
                case 5:
                    System.out.println("退出系统");
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重新选择");
            }







        }
    }
}
