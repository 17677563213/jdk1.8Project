package com.company;

import org.junit.Test;

import java.security.Key;

public class BaniryTreeTest02 {
    @Test
    public void method01(){
        BaniryTree<String, String> bt = new BaniryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        CustomerQueue<String> queue = bt.layerErgodic();
        for (Object key : queue) {
            System.out.println("结果"+key);
        }
//        巧妙!
//        判断左右两边是否存在元素,如果存在元素压入栈,弹出
//        采用队列的原因:先进先出的性质
//

    }



}
