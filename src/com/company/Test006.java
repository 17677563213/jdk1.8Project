package com.company;

import org.junit.Test;

import java.util.HashMap;

public class Test006 {

    /**
     * 采用字典的方式:
     */

    @Test
    public void method01(){
        int[] ints = {-1, -1};
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }


    public int[] twoSum(int[] nums, int target) {
        //字典容器:
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                return new int [] {i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;



    }
    /**
     * 对于在数组中查找两个数是否和为思路:
     * 1.采用两个for,其实就是采用两个双指针
     * 2.采用字典的方式
     */

}
