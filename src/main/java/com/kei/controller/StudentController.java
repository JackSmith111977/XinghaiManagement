package com.kei.controller;

import com.kei.service.Impl.StudentServiceImpl;
import com.kei.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentServiceImpl();



    // 启动学生管理系统入口
    public void start() throws SQLException {
        System.out.println("欢迎来到学生管理系统");

        boolean running = true;
        while(running){
            showMenu();
            int input = getIntInput("请输入您的选择：");

            switch (input){
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.deleteStudent();
                    break;
                case 3:
                    studentService.updateStudent();
                    break;
                case 4:
                    studentService.getAllStudents();
                    break;
                case 5:
                    System.out.println("退出系统");
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }

        }


    }

    // 展示菜单
    public void showMenu(){
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 修改学生");
        System.out.println("4. 查询所有学生");
        System.out.println("5. 退出系统");
    }

    // 获取数字输入
    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("请输入有效的数字！");
            scanner.next();
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        return input;
    }

    // 获取字符串输入
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }






}
