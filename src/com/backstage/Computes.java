package com.backstage;

import com.tool.MergeCollection;
import com.tool.ObtainSymbol;

import javax.swing.*;
import java.util.List;

public class Computes {

    public static String computes(String equation,JLabel jLabel){
        String result = "";
        //在数据匹配的情况下截取
        boolean flag = Matching.matching(equation);
        if(flag) {
            //获取所有的数字,通过判断符号来计算值。
            String[] nums =  equation.split("[+*/-]");
            //获取符号（+-*/）
            List<Character> symbolList = ObtainSymbol.obtainSymbol(equation);
            //计算方法
            String sumOrSub = compute(nums,symbolList);
            //界面显示结果
            jLabel.setText(sumOrSub);
        }else{
            jLabel.setText("输入值有误，如果不能查明，请查看后台报错！！！或者Label标签没有值！！！");
        }
        return result;
    }

    //计算方法，通过，数值数组和符号来计算结果，先计算乘法，除法等判断
    private static String compute(String[] nums,List<Character> symbolList){
        String result = "0";
        float results = new Float(nums[0]);
        //合并集合
        List<String> numOrSymList = MergeCollection.sumList(nums,symbolList);

        //双参数单循环，取出数，在取出下一个符号，判断符号是什么类型来计算。
        //这种情况下，有一个算法没有实现，哪就是*/先算的规则。

        //1.第一遍，检索所有的符号，如果有*/有先计算
        List<String> sumList = MUL.multiplication(numOrSymList);

        //2.再算加减，也就是如下算法
        result = Sum.sum(sumList);

        return result;
    }

}

//匹配算法类，类方法执行的事情就是讲输入的值，进行对比，是否和String数组中的值相同
class Matching{
    public static boolean matching(String equation){
        boolean flag = false;
        //匹配字符串是否符合要求begin
        String[] detection = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","."};
        //获取detection的字段
        for(int i=0;i<equation.length();i++){
            //创建一个boolean数组，当boolean数组为true的数量刚好和equation的长度相等，说明匹配成功
            boolean[] booleans = new boolean[equation.length()];
            //获取equation的字段
            for(int k=0;k<detection.length;k++) {
                //匹配,依次用detection中的字段去对比equation中字段的所有值
                if(detection[k].equals(String.valueOf(equation.charAt(i)))) {
                    booleans[i]=true;
                }
            }
            //当equation中的字段和detection中的字段，只要有一个不匹配都不计算
            if(booleans[i]==false){
                flag = false;
                System.err.println("输入的值不匹配，在第："+(i+1)+"个");
                try {
                    throw new Exception();//这里抛出异常，前台无法显示,尝试一下捕获异常
                    //捕获异常解决问题，实现了要求，既能在后台报错，又能在前台显示
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //用数组中前一个和后一个对比，看是否为true
            if(booleans[0]==true){
                //多与自己对比一次，问题不大。
                if(booleans[0]==booleans[i]){
                    flag=true;
                    System.out.println("数据匹配");
                }
            }
        }
        //匹配字符串是否符合要求end
        return flag;
    }
}