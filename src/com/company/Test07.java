package com.company;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test07 {





    @Test
    public void method05(){
        int [] [] str ={{1,2},{3,6} ,{9,10}};
        System.out.println(str.length);



    }

    @Test
    public void method06(){
        List list =new ArrayList();
        list.add(4, "java");
        System.out.println(list.get(4));


    }
}
