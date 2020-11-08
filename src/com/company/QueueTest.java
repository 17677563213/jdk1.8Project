package com.company;

import org.junit.Test;

public class QueueTest {
    @Test
    public void method01(){
        CustomerQueue<String> queue = new CustomerQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (Object o : queue) {
            System.out.println(o);
        }
//    自己写遍历方式:
        System.out.println(queue.getNumber());
        String s = queue.deQueue();
        System.out.println("删除元素"+s);
        for (Object o : queue) {
            System.out.println(o);
        }
        System.out.println("元素个数"+queue.getNumber());
    }
}
