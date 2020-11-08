package algorithm;

import org.junit.Test;

import javax.swing.text.Position;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Test02 {
    int [] numbers={1,2,4,3,10,6,9};

    @Test
    public void method01(){
        sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
    public void  sort(int [] numbers){
//        错误原因:length计算元素个数
//        for (int i = numbers.length-1; i >0 ; i--) {
//            for (int j = 0; j < i; j++) {
//                if(greater(numbers[j],numbers[j+1])){
//                    changePosition(numbers, j, j+1);
//                }
//
//            }


//

        for (int i = 0; i <numbers.length-1 ; i++) {
            for (int j = 0; j <numbers.length-1-i ; j++) {
                if(greater(numbers[j],numbers[j+1])){
                  changePosition(numbers, j, j+1);
//                }
                }

            }

        }
     }


//    疑问:为什么不直接拿结果进行比较:
//    需要对程序进行分析



    //比较两个数大小:
    public static boolean greater(Comparable cp1,Comparable cp2){
        int i = cp1.compareTo(cp2);
        return i>0;
    }
//替换位置:
    public static void  changePosition(int [] numbers ,int number1,int number2){
        int temp;
        temp=numbers[number1];
        numbers[number1]=numbers[number2];
        numbers[number2]=temp;
    }

    public double myPow(double x, int n) {
        for (int i = 1; i <=n ; i++) {
            x=x*x;
        }


        return x;

    }
    @Test
    public void method03(){
        double v = myPow(2.00000, 10);
        double pow = Math.pow(2.00000, 10);
        System.out.println(pow);
    }
    public  void  selection(int [] number ){
        for (int i = 0; i <number.length-1 ; i++) {
            int indexNumber=i;
            for (int j = i+1; j <number.length ; j++) {
                if(greater(number[indexNumber],number[j])){
                    changePosition(number, indexNumber, j);
                }
            }
        }
    }
    @Test
    public void method04(){
        sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
    /**
     *
     *
     *
     * 排序目前自己知道:1.冒泡排序,2选择排序,选择数字中最下的进行下标进行替换,再替换下标所对应的数据;3插入排序
     */

    public void insertSort(){
        for (int i = 1; i <numbers.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(greater(numbers[j-1],numbers[j])){
                    changePosition(numbers, j-1, j);
                    break;
                }
            }

        }

    }
    @Test
    public  void method05(){
        insertSort();
        System.out.println(Arrays.toString(numbers));

    }
//    希尔排序:思想就是减少了替换的方法调用次数


    public void  shellSort(){
        int h=1;
        while(h<(numbers.length/2)){
//            对步长进行修正:
            h=h*h+1;
        }
        while(h>=1){
            for (int i = h; i <numbers.length ; i++) {
                for (int j = i; j >=h ; j=j-h) {
                    if(greater(numbers[j-h],numbers[j])){
                        changePosition(numbers, j-h, j);
                    }else{
                        break;
                    }
                }

            }
            h=h/2;
        }
    }
    @Test
    public void method06(){
        shellSort();
        System.out.println(Arrays.toString(numbers));
    }

//    希尔排序:
    /**
     * 确定步长:
     *
     */

    @Test
    public void method07(){
        InputStream resourceAsStream = Test02.class.getClassLoader().getResourceAsStream("");


    }
    @Test
    public void method08(){
        System.out.println("现在是执行递归方法");

    }


    public int  factory(int number){
        if(number==1){
            return 1;
        }else{
            return factory(number-1)*number;
        }

    }
    @Test
    public void  factoriaTest(){
        int factory = factory(4);
        System.out.println(factory);


    }


    /**
     *
     */
    @Test
    public void method10(){
//        获取到该数组的最大位置
//        获取该数组下面索引
//        获取索引所对应的数值
        int [] numbers= {1,2,3};
        boolean b = method11(numbers);
        System.out.println(b);


    }
//    [2,3,1,1,4]
    public boolean method11(int [] numbers){

        if(numbers.length==1||numbers[0]>=numbers.length){
            return true;
        }

        int length = numbers.length;
//        开始位置所对应数值:
        int number = numbers[0];
        boolean flag=false;
        int h=0;

        for (int i = number; i < numbers.length; ) {

            if(i>=(length-1)){
                System.out.println("已经到终点");

                flag= true;
                break;
            } else{
                int number1 = numbers[i];
                if(number1==0){
                    i=i;
                }else{
                    i=i+number1;
                    if(i>=numbers.length){
                        flag=true;
                        break;
                    }
                };
                h++;
                if(h>=numbers.length){
                    flag=false;
                    break;
                }






            }

            
        }
        return flag;

    }


    /**
     * 思路:获取到数组的最后元素,在进行加一
     *
     */

    public int [] method12(int [] digits){
//        numbers[numbers.length-1]=numbers[numbers.length-1]+1;
//        if(numbers[numbers.length-1]==10){
//            ArrayList<Integer> integers = new ArrayList<>();
//            for (int i = 0; i <numbers.length-1 ; i++) {
//                integers.add(numbers[i]);
//
//            }
//            integers.add(1);
//            integers.add(0);
//            int[] ints = integers.stream().mapToInt((i) -> i).toArray();
//            return ints;
//
//        }else{
//
//            return numbers;
//        }
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int number : numbers) {
//            stringBuffer.append(number);
//        }
//        String s = stringBuffer.toString();
//        Long i = Long.parseLong(s)+1;
//        String s1 = new String(i+"");
//        char[] chars = s1.toCharArray();
//        int[] ints = new int[chars.length];
//
//        for (int j = 0; j < chars.length; j++) {
//            char aChar = chars[j];
//            ints[j]=chars[j]-'0';
//        }
//        return ints;
//获取长度
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {

            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;

//        这里面的思路太奇妙了:
//        从后面开始遍历>>结合对数字自动增加之后取余数,判断余数是否为0,如果为0的话,说明前面还需要继续运算,如果不为的话,直接返回
//        遇到这种遍历的情况需要手动进行控制

    }
    @Test
    public void method13(){
        int [] numbers= {9,8,7,6,5,4,3,2,1,0};
        int[] ints = method12(numbers);
        System.out.println(Arrays.toString(ints));
//        不懂算法写起代码是是这么的笨重!!
//        自己思路:将int类型数组,变成一个字符串,在编程一个int类型,加+1,之后在转化成int 的数组
    }

//    对数组进行扩容:
    @Test
    public void method14(){
        int [] numbers= {9,8,7,6,5,4,3,2,1,0};
        System.out.println(numbers.length);
        numbers=new int[numbers.length+1];
        System.out.println(numbers.length);
        System.out.println(Arrays.toString(numbers));
//        这里面是新创建一个对象,将该对象的地址指向原来的变量
    }


    public int [] method15(int [] numbers){
        int length = numbers.length;
        for (int i = length; i >=0 ; i--) {
            numbers[i]++;
            numbers[i]=numbers[i]%10;//取余数
//            不等于0:表示不是临界值,直接进行返回
            if(numbers[i]!=0){
                return numbers;
            }

        }
        numbers=new int [length+1];
        numbers[0]=1;
        return numbers;

//        不该定义的变量就不要进行定义,避免内存进行不必要的开销
//        能够使用Java内部的语句,代码就要使用,因为这是别人进行优化之后的代码,这样的执行效率比自己写的要高得多


    }

}




