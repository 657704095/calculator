import com.sun.javafx.collections.MappingChange;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        String str = "1+2+3-4+5-6-7*8/9*10*11/12";

        //拆分所有的字符串
        char[] num = new char[str.length()];
        for(int i=0;i<num.length;i++){
            num[i] = str.charAt(i);
        }

        String[] sum = str.split("[+*/-]");

        for(int i=0;i<sum.length;i++){
            System.out.println("sum:"+sum[i]+"\t"+i);
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
            }else{

            }
        }

        for (int i=0;i<charList.size();i++){
            System.out.println("symbol："+charList.get(i));
        }
    }
}


//思路是这样的用io写出java文件，用自己写的类加载器，加载，加载成功后，用反射运行main方法。
//这样就可以实现了将字符串作为代码执行
class Test2{

}


class Test5{
    //测试乘除法
    public static void main(String[] args){
        List<String> sumList = new ArrayList<String>();
        sumList.add("10");
        sumList.add("+");
        sumList.add("10");
        sumList.add("*");
        sumList.add("10");
        sumList.add("*");
        sumList.add("10");
        sumList.add("-");
        sumList.add("10");
        sumList.add("*");
        sumList.add("10");
        sumList.add("/");
        sumList.add("10");
        sumList.add("/");
        sumList.add("10");
        sumList.add("+");
        sumList.add("10");
        sumList.add("/");
        sumList.add("10");

        for(String s:sumList){
            System.out.println(s);
        }

        System.out.println("--------------------------------------");
        test(sumList);
    }

    //检索计算乘法，测试成功
    private static void test(List<String> sumList){
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
            for (int i = 0; i < indexMUL.size(); i++) {
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
            for(int i=0;i<indexDIV.size();i++){
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

        //显示结果集合
        for(String s:sumList){
            System.out.println(s);
        }

        //检测符号位置，如果集合中存在*/符号，那么继续调用递归
        if(sumList.indexOf("*")!=-1||sumList.indexOf("/")!=-1){
            test(sumList);
        }

    }

}