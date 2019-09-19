package com.backstage;

import java.util.List;

public class Sum {
    public static String sum(List<String> numOrSymList){
        float results = Float.valueOf(numOrSymList.get(0));
        //2.再算加减，也就是如下算法
        for(int i=0,i1=1;i<numOrSymList.size()||i1<numOrSymList.size();i+=2,i1+=2){
            String num = numOrSymList.get(i);
            if(i1<numOrSymList.size()) {
                String sym = numOrSymList.get(i1);
                if(sym.equals("+")){
                    if(i+2<numOrSymList.size()) results += new Float(numOrSymList.get(i+2));
                }else if(sym.equals("-")){
                    if(i+2<numOrSymList.size()) results -= new Float(numOrSymList.get(i+2));
                }
            }
        }
        return String.valueOf(results);
    }
}
