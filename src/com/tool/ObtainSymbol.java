package com.tool;

import java.util.ArrayList;
import java.util.List;

public class ObtainSymbol {
    //获取算式符号
    public static List<Character> obtainSymbol(String str){
        //拆分所有的字符串
        char[] num = new char[str.length()];
        for(int i=0;i<num.length;i++){
            num[i] = str.charAt(i);
        }

        List<Character> charList = new ArrayList<Character>();
        //取出所有的符号，放入数组中,放入数组缩容脑壳痛，用集合算了
        for(int i=0;i<num.length;i++){
            if(String.valueOf(num[i]).equals("+")){
                charList.add(num[i]);
            }else if(String.valueOf(num[i]).equals("-")){
                charList.add(num[i]);
            }else if(String.valueOf(num[i]).equals("*")){
                charList.add(num[i]);
            }else if(String.valueOf(num[i]).equals("/")){
                charList.add(num[i]);
            }
        }

        return charList;
    }
}
