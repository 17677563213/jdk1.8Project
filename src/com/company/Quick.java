package com.company;

import org.junit.Test;

import java.nio.file.attribute.PosixFileAttributes;

/**
 * 快排
 */
public class Quick {
    /**
     * 比较
     * @param number1
     * @param number2
     * @return
     */
    public static boolean comparable(Comparable number1 , Comparable number2){
        return number2.compareTo(number1)>0;
    }

    /**
     * 交换位置:
     * @param source
     * @param position1
     * @param position2
     */
    public static void  changePosition(Comparable [] source , int position1, int position2){
        Comparable temp = source[position1];
        source[position1]=source[position2];
        source[position2]=temp;
    }

    /**
     * 排序:
     * @param source
     */
    public  static void sort(Comparable [] source){
        int start = 0;
        int end = source.length-1;
        sort(source,start ,end);
    }


    public static void   sort(Comparable [] source , int start, int end){
        //条件判断:
        if(end<=start){
            return  ;
        }
        int partition = partition(source, start, end);
        sort(source,start,partition-1);
        sort(source,partition+1,end);
    }

    public  static int partition(Comparable [] source , int start ,int hi){
        Comparable key= source[start];
        int left=start;
        int right=hi+1;
        while(true){
            while(comparable(key, source[--right])){
                if(right<=left){
                    break;
                }
            }
            while(comparable(source[++left],key )){
                if(left>=right){
                    break;
                }
            }
            if(left>=right){
                break;
            }else{
                changePosition(source, left, right);
            }
        }
        changePosition(source, start, right);
        System.out.println("left="+left+"   right="+right);
        return right;
    }

    @Test
    public void method01(){
        Integer [] numbers = {1,4,2,10,33,55,0};
        Quick.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }




}
