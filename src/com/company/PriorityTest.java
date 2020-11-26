package com.company;


import org.junit.Test;

public class PriorityTest {
    @Test
    public void method01(){
        Priority<String> queue = new Priority<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        while(!queue.isEmpty()){
            System.out.println(queue.delMax());
        }
    }
}
