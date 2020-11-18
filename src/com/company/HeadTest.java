package com.company;

import org.junit.Test;

public class HeadTest {

    @Test
    public void method01(){
//       创建一个堆:
        Head<String> head = new Head<>(4);
//
        head.insert("A");
        head.insert("B");
        head.insert("C");
        head.insert("D");
        String str=null;
        while ((str=head.deMax())!=null){
            System.out.println(str);

        }

    }
}
