package com.company;

import org.junit.Test;

import javax.swing.plaf.SpinnerUI;

public class CustomerSelectSort {
    /**
     * 比较大小
     * @param number1
     * @param number2
     * @return
     */
    public static boolean comparable(Comparable number1,Comparable number2){
        return number1.compareTo(number2)>0;
    }
    /**
     * 交换位置:
     * @param source
     * @param position1
     * @param position2
     */
    public static void changePosition(Comparable [] source, int position1, int position2){
        Comparable temp = source[position1];
        source[position1]=source[position2];
        source[position2]=temp;
    }
    public static void sort(Comparable [] source){
        for (int i = 0; i <=source.length-2 ; i++) {
            int minIndex=i;
            //寻找外层每次循环中最小数的索引
            for (int j = i+1; j <source.length ; j++) {
                if(comparable(source[minIndex],j)){
                    minIndex=j;
                }
            }
            changePosition(source, minIndex, i);
        }
    }
    @Test
    public void method01(){
        Integer [] numbers={2,1,4,3};
        CustomerSelectSort.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
    /**
     * 选择排序需要比较,交换位置,同样需要两个for进行操作
     * 2.
     */


}
