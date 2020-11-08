package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test03 {


    /**
     * 思路:
     * 1.对字符换根据空格进行截取
     * 2.判断内容是否为空
     * 3.转化成字符获取长度
     *
     * @param str
     */
    public int test02(String str) {
        String[] s = str.split(" ");
        if (s.length == 0) {
            return 0;
        } else {
            return s[(s.length) - 1].toCharArray().length;
        }
    }
    @Test
    public void method01(){
        String trim = "".trim();
        System.out.println(trim.length());
        /**
         * 太妙了:
         * 这种思路:从时间复杂度,
         * 空间复杂度来看的话效率是非常的高
         * 如何降低时间复杂度:
         *  减少代码量
         *  减少代码执行次数
         */
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */

    public int [] method03(int[] nums1, int m, int[] nums2, int n){
        /**
         * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         * 代码解释:
         * 　　Object src : 原数组
         *    int srcPos : 从元数据的起始位置开始
         * 　　Object dest : 目标数组
         * 　　int destPos : 目标数组的开始起始位置
         * 　　int length  : 要copy的数组的长度
         */
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }
    @Test
    public void test04(){

        int[] nums1 = new int[100];
        nums1[0]=1;
        nums1[1]=2;
        nums1[2]=3;
        int[] nums2 = new int[3];
        nums2[0]=2;
        nums2[1]=5;
        nums2[2]=6;

        int[] ints = method03(nums1,3, nums2,3);
        System.out.println(Arrays.toString(ints));
    }
}
