package com.kei.service.Impl;

import com.kei.dao.TeacherDao;
import com.kei.pojo.Teacher;
import com.kei.service.TeacherService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * 邱显煜
 */
public class TeacherServiceImpl implements TeacherService {
    private Scanner scanner = new Scanner(System.in);
    private TeacherDao teacherDao = new TeacherDao();


    @Override
    public void addTeacher() throws SQLException {
        System.out.println("添加教师");
        System.out.println("请输入教师名称：");
        String name = scanner.next();
        System.out.println("请输入教师班级id：");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入教师授课开始时间：");
        LocalDate beginTime =LocalDate.parse(scanner.next());
        System.out.println("请输入教师授课结束时间：");
        LocalDate endTime = LocalDate.parse(scanner.next());
        System.out.println("请输入教师课时费：");
        double fee = scanner.nextDouble();

        Teacher teacher = new Teacher(null,name,courseId,beginTime,endTime,fee);

        teacherDao.addTeacher(teacher);



    }

    @Override
    public void deleteTeacherById() throws SQLException {
        System.out.println("请输入要删除的教师id：");
        int id = scanner.nextInt();
        scanner.nextLine();
        teacherDao.deleteTeacher(id);
    }

    @Override
    public void updateTeacher() throws SQLException {
        boolean running = true;
        while (running){
            System.out.println("请输入要修改的教师id，或输入0退出系统");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                running = false;
                break;
            }
            System.out.println("请输入要修改的信息：");
            System.out.println("1.修改教师姓名");
            System.out.println("2.修改教师班级ID");
            System.out.println("3.修改教师开始时间");
            System.out.println("4.修改教师结束时间");
            System.out.println("5.修改教师费用");
            System.out.println("6.取消修改");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("请输入新的教师姓名：");
                    String name = scanner.nextLine();
                    teacherDao.updateTeacherName(id, name);
                    break;
                case 2:
                    System.out.println("请输入新的教师班级ID：");
                    int classId = scanner.nextInt();
                    teacherDao.updateTeacherClassId(id, classId);
                    break;
                case 3:
                    System.out.println("请输入新的教师开始时间：");
                    LocalDate beginTime = LocalDate.parse(scanner.next());
                    teacherDao.updateTeacherBeginTime(id, beginTime);
                    break;
                case 4:
                    System.out.println("请输入新的教师结束时间：");
                    LocalDate endTime = LocalDate.parse(scanner.next());
                    teacherDao.updateTeacherEndTime(id, endTime);
                    break;
                case 5:
                    System.out.println("请输入新的教师费用：");
                    double fee = scanner.nextDouble();
                    teacherDao.updateTeacherFee(id, fee);
                    break;
                case 6:
                    System.out.println("取消修改");
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }

    }

    @Override
    public void queryTeacher() throws SQLException {
        System.out.println("请输入要查询的教师id：");
        int id = scanner.nextInt();
        scanner.nextLine();
        teacherDao.queryTeacher(id);
    }
}
