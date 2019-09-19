package res.abandon;

public class Sum {
    private static String basicCompute(String str,String[] num){
        String result = null;
        //定义和
        float resultNum = 0;
        //将拆分为数组的数据，遍历，以前加后的方式以此相加
        for(int i=0;i<num.length;i++){
            /*if(i<num.length-1) {
                sumNum = new Float(num[i]) + new Float(num[i + 1]);
                //前加后，无法累加，实际上只加了一次
            }*/
            //其实变量为0，直接加上数组中所有的值。
            resultNum += new Float(num[i]);//原来样写重复代码过多
        }
        result = String.valueOf(resultNum);
        return result;
    }

    //定义一个加法，加法逻辑正确
    private static float sum(String[] num){
        //定义和
        float sumNum = 0;
        for(int i=0;i<num.length;i++) {
            sumNum += new Float(num[i]);
        }
        return sumNum;
    }

    //定义一个减法,减法逻辑正确
    private static float sub(String[] num){
        //定义一个结果
        float subNum = new Float(num[0]);
        for(int i=1;i<num.length;i++) {
            subNum -= new Float(num[i]);
        }
        return subNum;
    }

    //定义一个乘法,用加法写，乘以几就累加几次。


    //定义一个除法，除以几就累减几次


    //减少加减法代码量
    private static String basicCompute2(String str,String[] num){
        String result = null;
        //定义和
        float resultNum = 0;
        //将拆分为数组的数据，遍历，以前加后的方式以此相加

        if(str.equals("sum")){
            resultNum = sum(num);
        }else if(str.equals("sub")){
            resultNum = sub(num);
        }else if(str.equals("MUL")){

        }else if(str.equals("DIV")){

        }

        result = String.valueOf(resultNum);
        return result;
    }
}
