package com.kei.controller;

import com.kei.service.Impl.PianoServiceImpl;
import com.kei.service.PianoService;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 崔棋铭
 */

public class PianoController {
    private final Scanner scanner = new Scanner(System.in);
    private final PianoService pianoService = new PianoServiceImpl();

    public void start() throws SQLException {
        System.out.println("--- 进入琴管理系统 ---");
        boolean running = true;
        while(running){
            showMenu();
            System.out.println("请输入您的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice){
                case 1:
                    pianoService.addPiano();
                    break;
                case 2:
                    pianoService.deletePiano();
                    break;
                case 3:
                    pianoService.updatePiano();
                    break;
                case 4:
                    pianoService.selectAllPianos();
                    break;
                case 5:
                    System.out.println("--- 退出琴管理系统 ---");
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    public void showMenu(){
        System.out.println("1. 添加琴");
        System.out.println("2. 删除琴");
        System.out.println("3. 修改琴信息");
        System.out.println("4. 查看所有琴");
        System.out.println("5. 返回主菜单");
    }
}
