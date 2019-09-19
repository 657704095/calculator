package com.backstage;

import java.util.ArrayList;
import java.util.List;

public class MUL {
    /**
     *retrun 纯加减法的算式集合
     */
    public static List<String> multiplication(List<String> sumList){
        //检索符号begin
        List<Integer> indexMUL = new ArrayList<Integer>();
        for(int i=1;i<sumList.size();i+=2){
            if(sumList.get(i).equals("*")){
                indexMUL.add(i);
            }
        }
        //检索符号end

        //乘法
        if(indexMUL!=null&&indexMUL.size()>0){
            float sum = Float.valueOf(sumList.get(indexMUL.get(0) - 1));
            sum = sum * Float.valueOf(sumList.get(indexMUL.get(0) + 1));//先计算一次
            //少计算一个符号位导致的错误
            int removeNum = 1;//计数器，用来计算符合连接*的个数
            for (int i = 1; i < indexMUL.size(); i++) {//让它从下一个累乘解决问题。
                int index = indexMUL.get(i);
                int index2 = 0;
                if((i+1)<indexMUL.size()){index2 = indexMUL.get(i+1);}//判断是否*号相连，隔行不算
                if(index2==(index+2)){sum = sum * Float.valueOf(sumList.get(index + 1));removeNum++;}//累乘法
            }
            //移除不要的数据和符号，用结果去填充
            for(int k=1;k<=(removeNum*2+1);k++) {
                sumList.remove(indexMUL.get(0) - 1);
            }
            sumList.add(indexMUL.get(0) - 1,String.valueOf(sum));
        }


        //检索符号begin
        List<Integer> indexDIV = new ArrayList<>();
        for(int i=1;i<sumList.size();i+=2){
            if(sumList.get(i).equals("/")){
                indexDIV.add(i);
            }
        }
        //检索符号end

        //除法
        if(indexDIV!=null&&indexDIV.size()>0){
            float sum = Float.valueOf(sumList.get(indexDIV.get(0)-1));
            sum = sum/Float.valueOf(sumList.get(indexDIV.get(0)+1));
            int removeNum = 1;//计数器，用来计算符合连接*的个数
            for(int i=1;i<indexDIV.size();i++){
                int index = indexDIV.get(i);
                int index2 = 0;
                if((i+1)<indexDIV.size()){index2 = indexDIV.get(i+1);}
                if(index2==(index+2)){sum = sum/Float.valueOf(sumList.get(index+1));removeNum++;}
            }
            //移除不要的数据和符号，用结果去填充
            for(int k=1;k<=(removeNum*2+1);k++) {
                sumList.remove(indexDIV.get(0) - 1);
            }
            sumList.add(indexDIV.get(0) - 1,String.valueOf(sum));
        }
        //检测符号位置，如果集合中存在*/符号，那么继续调用递归
        if(sumList.indexOf("*")!=-1||sumList.indexOf("/")!=-1){
            multiplication(sumList);
        }
        return  sumList;
    }
}
