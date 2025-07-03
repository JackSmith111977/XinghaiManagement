package com.kei.controller;

import com.kei.service.Impl.CourseServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseController {
    private final CourseServiceImpl courseService = new CourseServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("\n=== 课程管理 ===");
            System.out.println("1. 添加课程");
            System.out.println("2. 删除课程");
            System.out.println("3. 更新课程");
            System.out.println("4. 查看所有课程");
            System.out.println("5. 查询指定课程");
            System.out.println("6. 返回主菜单");
            System.out.print("请选择：");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        courseService.addCourse();
                        break;
                    case 2:
                        courseService.deleteCourse();
                        break;
                    case 3:
                        courseService.updateCourse();
                        break;
                    case 4:
                        courseService.getAllCourses();
                        break;
                    case 5:
                        courseService.getCourseById();
                        break;
                    case 6:
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