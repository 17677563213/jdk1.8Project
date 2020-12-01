package com.company;

import org.junit.Test;

public class CustomerInsterSort {
    /**
     * 比较大小
     * @param number1
     * @param number2
     * @return
     */
    public static  boolean comarable(Comparable number1,Comparable number2){
        return number1.compareTo(number2)>0;
    }

    /**
     * 交换位置
     * @param source
     * @param position1
     * @param position2
     */
    public static void changePosition(Comparable [] source, int position1 , int position2){
        Comparable tem =source[position1];
        source[position1]=source[position2];
        source[position2]=tem;
    }
    public static void  sort(Comparable [] source){
        for (int i = 1; i <source.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(comarable(source[j-1],source[j])){
                    changePosition(source, j-1, j);
                }else{
                    break;
                }
            }
        }
    }
    @Test
    public void method01(){
        Integer [] numbers={1,2,4,6};
        CustomerInsterSort.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
