package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); // Khoi tao cua so window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // tat = dau x
        window.setResizable(false); // khong the dieu chinh kich thuoc cua so
        window.setTitle("Nice Escape");

        GamePanel gamePanel = new GamePanel();
        window.setIconImage(gamePanel.getPlayer().getDown1());
        window.add(gamePanel); // them gamepanel vao jframe
        window.pack(); // de fit cua so voi cai gamepanel --> chinh cua so = game panel

        window.setLocationRelativeTo(null); // cua so xuat hien o chinh giua man hinh may tinh
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.StartGameThread();
        }
}