package com.kei.service.Impl;

import com.kei.dao.CustomerDao;
import com.kei.dao.PurchaseDao;
import com.kei.pojo.Customer;
import com.kei.pojo.Purchase;
import com.kei.service.CustomerService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * 王俊锡
 */

public class CustomerServiceImpl implements CustomerService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerDao customerDao = new CustomerDao();
    private static final PurchaseDao purchaseDao = new PurchaseDao();
    @Override
    public void addCustomer() throws SQLException {
        System.out.println("请输入顾客姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入顾客的手机号：");
        String phone = scanner.nextLine();
        System.out.println("请输入顾客送货地址：");
        String address = scanner.nextLine();
        Customer customer = new Customer(null, name, phone, address);
        customerDao.addCustomer(customer);
    }

    @Override
    public void deleteCustomer() throws SQLException {
        System.out.println("请输入顾客ID：");
        int id = scanner.nextInt();
        scanner.nextLine();
        customerDao.deleteCustomer(id);
    }

    @Override
    public void updateCustomer() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("请输入顾客ID（若输入0则推出修改系统）：");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                running = false;

                break;
            }
            System.out.println("请输入要修改的信息：");
            System.out.println("1.修改姓名");
            System.out.println("2.修改手机号");
            System.out.println("3.修改送货地址");
            System.out.println("4.退出修改系统");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("请输入顾客姓名");
                    String name = scanner.next();
                    customerDao.updateCustomerName(id,name);
                    break;
                case 2:
                    System.out.println("请输入顾客手机号");
                    String phone = scanner.next();
                    customerDao.updateCustomerPhone(id,phone);
                    break;
                case 3:
                    System.out.println("请输入顾客送货地址");
                    String address = scanner.nextLine();
                    customerDao.updateCustomerAddress(id,address);
                    break;
                case 4:
                    System.out.println("取消修改,返回顾客管理系统");
                    running = false;

                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    @Override
    public void addCustomerPurchase() throws SQLException {
        System.out.println("请输入顾客ID：");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入顾客的订单日期（xxxx-xx-xx）：");
        LocalDate purchaseDate = LocalDate.parse(scanner.next());
        scanner.nextLine();
        System.out.println("请输入顾客的订单金额：");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入顾客的订单销售人：");
        String sellerName = scanner.nextLine();
        Purchase purchase = new Purchase(null, customerId, purchaseDate, price, sellerName);
        purchaseDao.addCustomerPurchase(purchase);
    }

    @Override
    public void queryCustomerPurchase() throws SQLException {
        System.out.println("请输入顾客的ID：");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        purchaseDao.queryCustomerPurchase(customerId);
    }

    @Override
    public void deleteCustomerPurchase() throws SQLException {
        System.out.println("请输入顾客的ID：");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入购买记录ID：");
        int purchaseId = scanner.nextInt();
        scanner.nextLine();
        purchaseDao.deleteCustomerPurchase(customerId, purchaseId);
    }

    @Override
    public void updateCustomerPurchase() throws SQLException {
        boolean running = true;
        while (running){
            System.out.println("请输入顾客的ID：");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("请输入要修改的购买记录ID：");
            int purchaseId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("请输入要修改的信息：");
            System.out.println("1.修改购买日期");
            System.out.println("2.修改购买价格");
            System.out.println("3.修改销售人");
            System.out.println("4.取消修改");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("请输入购买日期（格式为 xx-xx-xx）：");
                    LocalDate purchaseDate = LocalDate.parse(scanner.next());
                    scanner.nextLine();
                    purchaseDao.updatePurchaseDate(customerId, purchaseId, purchaseDate);
                    break;
                case 2:
                    System.out.println("请输入购买价格：");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    purchaseDao.updatePrice(customerId, purchaseId, price);
                    break;
                case 3:
                    System.out.println("请输入销售人：");
                    String sellerName = scanner.next();
                    scanner.nextLine();
                    purchaseDao.updateSellerName(customerId, purchaseId, sellerName);
                    break;
                case 4:
                    System.out.println("取消修改，返回顾客管理系统");
                    running = false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入");
            }
        }
    }

    @Override
    public void queryAllCustomerPurchase() throws SQLException {
        System.out.println("所有顾客的购买记录如下：");
        customerDao.queryAllCustomerPurchase();
    }

}
