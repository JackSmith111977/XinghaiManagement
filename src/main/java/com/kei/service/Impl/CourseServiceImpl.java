package com.kei.service.Impl;

import com.kei.dao.CourseDao;
import com.kei.pojo.Course;
import com.kei.service.CourseService;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CourseDao courseDao = new CourseDao();

    @Override
    public void addCourse() throws SQLException {
        System.out.println("\n=== 添加课程 ===");
        Course course = new Course();

        System.out.print("课程名称：");
        course.setName(scanner.nextLine());

        System.out.print("乐器类型：");
        course.setInstrumentType(scanner.nextLine());

        System.out.print("课程价格：");
        course.setPrice(new BigDecimal(scanner.nextLine()));

        System.out.print("总课次：");
        course.setLessonCount(Integer.parseInt(scanner.nextLine()));

        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse() throws SQLException {
        System.out.println("\n=== 删除课程 ===");
        System.out.print("输入要删除的课程ID：");
        int id = Integer.parseInt(scanner.nextLine());
        courseDao.deleteCourse(id);
    }

    @Override
    public void updateCourse() throws SQLException {
        System.out.println("\n=== 更新课程 ===");
        System.out.print("输入要更新的课程ID：");
        int id = Integer.parseInt(scanner.nextLine());

        Course course = courseDao.getCourseById(id);
        if (course == null) {
            System.out.println("未找到指定课程！");
            return;
        }

        System.out.print("新课程名称(留空不修改)：");
        String name = scanner.nextLine();
        if (!name.isEmpty()) course.setName(name);

        System.out.print("新乐器类型(留空不修改)：");
        String type = scanner.nextLine();
        if (!type.isEmpty()) course.setInstrumentType(type);

        System.out.print("新课程价格(留空不修改)：");
        String price = scanner.nextLine();
        if (!price.isEmpty()) course.setPrice(new BigDecimal(price));

        System.out.print("新课次(留空不修改)：");
        String count = scanner.nextLine();
        if (!count.isEmpty()) course.setLessonCount(Integer.parseInt(count));

        courseDao.updateCourse(course);
    }

    @Override
    public void getAllCourses() throws SQLException {
        courseDao.getAllCourses();
    }

    @Override
    public void getCourseById() throws SQLException {
        System.out.println("\n=== 查询课程 ===");
        System.out.print("输入课程ID：");
        int id = Integer.parseInt(scanner.nextLine());

        Course course = courseDao.getCourseById(id);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("未找到指定课程！");
        }
    }
}