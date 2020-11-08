package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        int [] numbers={3,2,4};
        int[] ints = test02.twoSum(numbers, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(target-nums[i]==nums[j]){
                    int[] ints = {i,j};

                    return ints;

                }

            }
        }
        return null;





    }


    public boolean method01( int number){

        String s = number + "";
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = chars.length-1; i >=0 ; i--) {
             stringBuffer.append(chars[i]);
        }



        if(stringBuffer.toString().equals(s)){
            return true;
        }else{
            return false;
        }


    }
    @Test
    public void method02(){
        double b =method03(2.00000, 10);
        System.out.println(b);

    }

    public double method03(double number1,int number2){
        Integer integer = new Integer(number1+"");
        for (int i = 1; i <=number2 ; i++) {
            integer=integer*integer;
        }
        double v = integer.doubleValue();
        return v;


    }
    /**
     * 这里面使用到的思想:
     *  1.两个数之间进行交换
     *  2.两个数之间进行比较
     *  3.采用两个for进行循环 核心需要理解这两个for的作用含义
     *  时间复杂度:n^2
     */


    /**
     * 这个思路可以啊我要,一个高级算法工程师
     */

}
