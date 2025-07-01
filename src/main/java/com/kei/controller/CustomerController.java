package com.kei.controller;

import com.kei.service.CustomerService;
import com.kei.service.Impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService = new CustomerServiceImpl();

    //启动顾客管理系统入口
    public void start() throws SQLException {
        System.out.println("欢迎来到顾客管理系统");

        boolean running = true;
        while(running){
            System.out.println("1. 添加顾客");
            System.out.println("2. 删除顾客和购琴信息");
            System.out.println("3. 修改顾客");
            System.out.println("4. 根据顾客ID添加购琴信息");
            System.out.println("5. 根据顾客ID查看购琴信息");
            System.out.println("6. 根据顾客ID删除购琴信息");
            System.out.println("7. 根据顾客ID修改购琴信息");
            System.out.println("8. 查看所有顾客所有购买信息");
            System.out.println("9. 退出");

            System.out.println("请输入你的选择");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 1:
                    //添加顾客
                    customerService.addCustomer();
                    break;
                case 2:
                    //删除顾客和购琴信息
                    customerService.deleteCustomer();
                    break;
                case 3:
                    //修改顾客
                    customerService.updateCustomer();
                    break;
                case 4:
                    //根据顾客姓名添加购琴信息
                    customerService.addCustomerPurchase();
                    break;
                case 5:
                    //根据顾客姓名查看购琴信息
                    customerService.queryCustomerPurchase();
                    break;
                case 6:
                    //根据顾客姓名删除购琴信息
                    customerService.deleteCustomerPurchase();
                    break;
                case 7:
                    //根据顾客姓名修改购琴信息
                    customerService.updateCustomerPurchase();
                    break;
                case 8://look all
                    customerService.queryAllCustomerPurchase();
                    break;
                case 9:
                    System.out.println("退出顾客管理系统");
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

}
