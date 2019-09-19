package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HMI extends JFrame {

    private String input = null;

    public HMI(){
        //主体开始
        this.setSize(800,600);
        this.setLayout(new FlowLayout());//流布局
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //主体结束


        //添加输入
        JTextField jTextArea = new JTextField();
        //jTextArea.setRows(1);
        jTextArea.setColumns(20);
        this.add(jTextArea);

        //添加显示
        JLabel jLabel = new JLabel();
        jLabel.setSize(20,20);
        this.add(jLabel);

        //添加输入确认
        JButton yes = new JButton("输入确认");
        this.add(yes);

        //添加按键
        JButton[] buttons = new JButton[10];
        for(int i=0;i<10;i++) {
            buttons[i] = new JButton();
            buttons[i].setText(String.valueOf(i));
            this.add(buttons[i]);
        }

        //添加按键
        JButton sum = new JButton("+");
        JButton minus = new JButton("-");
        JButton ride = new JButton("*");
        JButton divide = new JButton("/");
        JButton radix = new JButton(".");
        JButton equal = new JButton("=");

        //加入容器
        this.add(sum);
        this.add(minus);
        this.add(ride);
        this.add(divide);
        this.add(radix);
        this.add(equal);

        //添加清除按钮
        JButton clear = new JButton("clear");
        JButton retreat = new JButton("←");
        this.add(clear);
        this.add(retreat);

        //给清除按钮添加事件
        Listen.clear(clear,jLabel);
        Listen.clear(retreat,jLabel);

        //添加按钮事件
        Listen.computeButton(sum,jLabel);
        Listen.computeButton(minus,jLabel);
        Listen.computeButton(ride,jLabel);
        Listen.computeButton(divide,jLabel);
        Listen.computeButton(radix,jLabel);

        //添加等于事件，以及输入确认事件
        Listen.compute(equal,jLabel,jTextArea);
        Listen.compute(yes,jLabel,jTextArea);

        //添加事件
        Listen.keyListen(buttons,jLabel);

        this.setVisible(true);
    }
}