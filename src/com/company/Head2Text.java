package com.company;

import org.junit.Test;

public class Head2Text {
    @Test
    public void method01(){
        Head02<String> heap = new Head02<>(20);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String content;
        while((content=heap.delMax())!=null){
            System.out.print(content+",");

        }

    }


}
