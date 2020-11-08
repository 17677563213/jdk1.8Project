package com.company;

import org.junit.Test;

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
}
