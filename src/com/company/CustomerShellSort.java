package com.company;

import org.junit.Test;

public class CustomerShellSort {
    /**
     * 比较
     * @param number1
     * @param number2
     * @return
     */
    public static boolean comarable(Comparable number1,Comparable number2){
        return number1.compareTo(number2)>0;
    }

    /**
     * 交换位置
     * @param source
     * @param position1
     * @param position2
     */
    public static void changePostion(Comparable [] source , int position1 , int position2){
        Comparable tem = source[position1];
        source[position1] = source[position2];
        source[position2] = tem;
    }
    public static void sort(Comparable [] source){
        //间距:
        int space = 1;
        //计算分组间距:
        while(space<(source.length/2)){
            space=space*2+1;
        }
        //不断缩小分组间距:
       while(space>=1){
           //分组插入:
           for (int i = space; i <source.length ; i++) {
               for (int j = i; j >=space ; j=j-space) {
                   if(comarable(source[j-space],source[j])){
                       changePostion(source, j-space, j);
                   }else{
                       //表示已经找到插入的位置
                       break;
                   }
               }
           }
           space=space/2;
       }
    }

    //测试:
    @Test
    public void method01(){
        Integer [] numbers={11,2,6,4,10};
        CustomerShellSort.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
    /**
     * 总结:
     *  1.希尔排序是建立在 插入排序的基础上,
     *  先将数据进行分组,之后对每组数据才取插入排序的操作;
     *
     */
}
