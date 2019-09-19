package com.tool;

import java.util.ArrayList;
import java.util.List;

public class MergeCollection {
    //合并集合
    public static List<String> sumList(String[] nums,List<Character> symbolList){
        //合并集合 begin
        List<String> sumList = new ArrayList<String>();
        for(int i=0;i<nums.length;i++){
            //合成一个集合，前一个数据后一个为符号，或者，前一个为符号，后一个为数据
            sumList.add(nums[i]);
            if(i<symbolList.size()){
                sumList.add(String.valueOf(symbolList.get(i)));
            }
        }
        //合并集合 end
        return sumList;
    }
}
