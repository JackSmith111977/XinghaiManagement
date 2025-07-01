package com.kei.service.Impl;

import com.kei.dao.PianoDao;
import com.kei.pojo.Piano;
import com.kei.service.PianoService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class PianoServiceImpl implements PianoService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PianoDao pianoDao = new PianoDao();

    @Override
    public void addPiano() throws SQLException {
        System.out.println("请输入琴的名称/型号：");
        String name = scanner.nextLine();
        System.out.println("请输入琴的种类（如：钢琴、小提琴）：");
        String type = scanner.nextLine();
        System.out.println("请输入琴的价格：");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine(); // 消耗换行符
        System.out.println("请输入琴的生产厂家：");
        String manufacturer = scanner.nextLine();
        Piano piano = new Piano(null, name, type, price, manufacturer);
        pianoDao.addPiano(piano);
    }

    @Override
    public void deletePiano() throws SQLException {
        System.out.println("请输入要删除的琴的ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        pianoDao.deletePiano(id);
    }

    @Override
    public void updatePiano() throws SQLException {
        System.out.println("请输入要修改的琴的ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        System.out.println("请输入琴的【新】名称/型号：");
        String name = scanner.nextLine();
        System.out.println("请输入琴的【新】种类：");
        String type = scanner.nextLine();
        System.out.println("请输入琴的【新】价格：");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine(); // 消耗换行符
        System.out.println("请输入琴的【新】生产厂家：");
        String manufacturer = scanner.nextLine();

        Piano piano = new Piano(id, name, type, price, manufacturer);
        pianoDao.updatePiano(piano);
    }

    @Override
    public void selectAllPianos() throws SQLException {
        System.out.println("--- 所有琴的库存信息如下 ---");
        pianoDao.selectAllPianos();
        System.out.println("--------------------------");
    }
}
