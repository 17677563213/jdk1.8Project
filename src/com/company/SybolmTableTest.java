package com.company;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SybolmTableTest {

    @Test
    public void method01(){
        SybomlTable<Integer, String> sybomlTable = new SybomlTable<>();
        sybomlTable.put(1, "wxy");
        sybomlTable.put(2, "yuexia");
        sybomlTable.put(2, "红尘");
        System.out.println("元素个数: "+sybomlTable.getNumber());
        System.out.println("获取元素"+sybomlTable.getElement(2));
        System.out.println("删除元素"+sybomlTable.delElement(2));
        System.out.println("元素个数"+sybomlTable.getNumber());


    }
    @Test
    public void method02(){
        List<Integer> integers = Arrays.asList(1, 2, 4, 11, 7, 10);
        Stream<Integer> sorted = integers.stream().sorted();
        sorted.forEach((e) ->System.out.println(e));
        /**
         * 链表:
         */


    }
}
