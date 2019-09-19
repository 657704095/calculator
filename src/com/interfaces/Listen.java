package com.interfaces;

import com.backstage.Computes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listen {
    //数字输入事件
    public static void keyListen(JButton[] buttons,JLabel jLabel){
        for(int i=0;i<10;i++) {
            int k = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String string = jLabel.getText();
                    jLabel.setText(string + String.valueOf(k));
                }
            });
        }

    }

    //加减乘除事件
    public static void computeButton(JButton jButton,JLabel jLabel){
        //String Lab = jLabel.getText();//获取显示面板的值，在这里获取的值每个都是最开始的
        //而不是点击之后获取的。
        String butStr = jButton.getText();//获取按钮的值
        //在按钮点击被触发后累加
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Lab = jLabel.getText();//获取显示面板的值
                jLabel.setText(Lab+butStr);//累加显示面板的值
            }
        });
    }

    //等于事件，和输入确认事件，他们都做一件事情，返回界面的数值。
    public static String compute(JButton jButton,JLabel jLabel,JTextField jTextArea){
        ComputeListener computeListener = new ComputeListener();//创建自己写的监听器类
        computeListener.setjLabel(jLabel);//赋予监听器jLabel属性
        computeListener.setjTextArea(jTextArea);//赋予输入面板属性
        computeListener.setjButton(jButton);//赋予按钮属性，用以判断哪个键被执行了
        jButton.addActionListener(computeListener);//添加监听
        return computeListener.getLab();//无法返回的原因，是因为，事件未触发的时候以及被执行了
    }

    //清除事件，和后退事件
    public static void clear(JButton jButton,JLabel jLabel){

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jButton.getText().equals("clear")){
                    jLabel.setText("");
                }else if(jButton.getText().equals("←")){
                    String old = jLabel.getText();//获取数据
                    //截取数据
                    String newStr = old.substring(0,old.length()-1);
                    jLabel.setText(newStr);//放置新数据
                }
            }
        });

    }
    //输入清除
    public static void inputClear(JButton jButton,JTextField jTextArea){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
            }
        });
    }
}

class ComputeListener implements ActionListener{
    private String lab = "没有值无法计算";

    private JLabel jLabel = null;

    private JButton jButton = null;

    private JTextField jTextArea = null;

    public void setjButton(JButton jButton){
        this.jButton = jButton;
    }

    public void setjTextArea(JTextField jTextArea) {
        this.jTextArea = jTextArea;
    }

    public void setjLabel(JLabel jLabel){
        this.jLabel = jLabel;
    }

    public String getLab(){
        return lab;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(jButton.getText().equals("=")) {
            lab = jLabel.getText();
        }else if(jButton.getText().equals("输入确认")){
            lab = jTextArea.getText();
        }
        System.out.println(lab);

        //计算方法
        Computes.computes(lab,jLabel);
    }
}
