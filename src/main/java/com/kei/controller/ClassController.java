package com.kei.controller;

import com.kei.service.Impl.ClassServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 马璞
 */

public class ClassController {
    private final ClassServiceImpl classService = new ClassServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("\n=== 班级管理 ===");
            System.out.println("1. 创建班级");
            System.out.println("2. 删除班级");
            System.out.println("3. 更新班级信息");
            System.out.println("4. 添加学生到班级");
            System.out.println("5. 从班级移除学生");
            System.out.println("6. 查看班级学生");
            System.out.println("7. 查看教师负责的班级");
            System.out.println("8. 返回主菜单");
            System.out.print("请选择：");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        classService.createClass();
                        break;
                    case 2:
                        classService.deleteClass();
                        break;
                    case 3:
                        classService.updateClass();
                        break;
                    case 4:
                        classService.addStudentToClass();
                        break;
                    case 5:
                        classService.removeStudentFromClass();
                        break;
                    case 6:
                        classService.getStudentsByClass();
                        break;
                    case 7:
                        classService.getClassesByTeacher();
                        break;
                    case 8:
                        running = false;
                        break;
                    default:
                        System.out.println("无效输入！");
                }
            } catch (NumberFormatException e) {
                System.out.println("输入错误：请输入有效的数字！");
            } catch (SQLException e) {
                System.out.println("数据库错误：" + e.getMessage());
            }
        }
    }
}