package com.company;

import org.junit.Test;

import java.util.Arrays;

/**
 * 需要:
 *  1.通过堆的方式,堆字符串进行排序
 *  该类设计到的方法
 *  1.比较两个位置大小
 *  2.交换位置
 *  3下沉
 *  4.
 */

public class HeadSort02 {
    //判断两个位置大小:
    public static boolean comparable(Comparable [] head,int position ,int position2){
        return head[position].compareTo(head[position2])<0;
    }
    //交换位置:
    public static void  changePosition(Comparable [] head ,int position,int position2){
        Comparable tem=head[position];
        head[position]=head[position2];
        head[position2]=tem;
    }
    public static Comparable [] changeToHead(Comparable [] source){
        Comparable[] head = new Comparable[source.length + 1];
        System.arraycopy(source, 0, head, 1, source.length);
        //调整元素位置:
        for (int i = (head.length/2); i >0 ; i--) {
            sink(head, i, head.length-1);
        }
        return head;
        /**
         * 犯错误:
         *  1.长度不明确,
         *  2.元素的个数
         *  3.每一个元素都需要进行调整
         */


    }

    public static void sortSource(Comparable[] source){
        Comparable[] head = changeToHead(source);
        System.out.println(Arrays.toString(head));
        System.out.println("长度"+head.length);
        int N = head.length-1;
        while(N!=1){
            changePosition(head, 1, N);
            N--;
            sink(head, 1, N);
        }
        System.arraycopy(head, 1, source, 0, source.length);
    }
    //堆某个方法进行下沉操作,不是堆每一个元素
    public static void sink(Comparable [] head ,int position , int range){
        while(position*2<=range){
            int max=0;
            //判断是否存在右边节点:
            if(position*2+1<=range){
                if(comparable(head, position*2, position*2+1)){
                    max=position*2+1;
                }else{
                    max=position*2;
                }
            }else{
                max=position*2;
            }
            if(!comparable(head, position, max)){
                break;
            }else{
                changePosition(head, position, max);
                position=max;
            }
        }
    }

    @Test
    public void test01(){
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        sortSource(arr);
        System.out.println(Arrays.toString(arr));
        /**
         * [null, X, T, S, P, L, R, A, M, O, E, E]
         * [A, E, E, L, M, O, P, R, S, T, X]
         */


    }
    @Test
    public void method02(){
        int [] numbers={1,2,4,5,6};
        System.out.println(numbers.length);

    }
    @Test
    public void method03(){
    }





}
