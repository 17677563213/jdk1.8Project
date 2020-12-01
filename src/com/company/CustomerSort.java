package com.company;

import org.junit.Test;

public class CustomerSort {


    /**
     * 比较
     * @param number1
     * @param number2
     * @return
     */
    public static boolean comparable(Comparable number1,Comparable number2){
        return number1.compareTo(number2)>0;
    }

    /**
     * 交换位置
     * @param arr
     * @param position1
     * @param position2
     */
    public static void chanagePosition(Comparable [] arr, int position1 ,int position2){
        Comparable temp= arr[position1];
        arr[position1]=arr[position2];
        arr[position2]=temp;


    }

    /**
     * 排序
     * @param sources
     */
    public  static void sort(Comparable [] sources){
        for (int i = sources.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(comparable(sources[j],sources[j+1])){
                    chanagePosition(sources, j, j+1);

                }

            }

        }
    }

    /**
     * 冒泡排序:
     * 主要的操作:
     * 1.定义两个数的比较方法
     * 2.定义两个数交换位置的方法
     * 3.通过两个for循环进行交换位置,外层的for循环用来控制已经排序好的元素就不参与到
     */
    @Test
    public void method01(){
        Integer [] numbers={2,4,5,1,9};
        CustomerSort.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
}
