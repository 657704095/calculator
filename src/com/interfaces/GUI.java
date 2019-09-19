package com.interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel1;
    private JButton seven;
    private JButton four;
    private JButton one;
    private JButton zero;
    private JButton eight;
    private JButton five;
    private JButton two;
    private JButton radixPoint;
    private JButton nine;
    private JButton six;
    private JButton three;
    private JButton equal;
    private JButton sum;
    private JButton subtraction;
    private JButton multiply;
    private JButton divide;
    private JButton inputYes;
    private JLabel display;
    private JButton clean;
    private JButton retreat;
    private JButton b3;
    private JButton inputClear;
    private JTextField input;
    private JButton b2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        GUI gui = new GUI();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();

        gui.init();

        frame.setVisible(true);
    }

    //事件加载
    private void init(){
        //给清除按钮添加事件
        Listen.clear(clean,display);
        Listen.clear(retreat,display);
        Listen.inputClear(inputClear,input);

        //添加按钮事件
        Listen.computeButton(sum,display);
        Listen.computeButton(subtraction,display);
        Listen.computeButton(multiply,display);
        Listen.computeButton(divide,display);
        Listen.computeButton(radixPoint,display);

        //添加等于事件，以及输入确认事件
        Listen.compute(equal,display,input);
        Listen.compute(inputYes,display,input);

        JButton[] jButtons = new JButton[10];
        jButtons[0] = zero;
        jButtons[1] = one;
        jButtons[2] = two;
        jButtons[3] = three;
        jButtons[4] = four;
        jButtons[5] = five;
        jButtons[6] = six;
        jButtons[7] = seven;
        jButtons[8] = eight;
        jButtons[9] = nine;

        //添加事件
        Listen.keyListen(jButtons,display);
    }

}
