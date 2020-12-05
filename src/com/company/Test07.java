package com.company;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test07 {



    @Test
     public void method04(){
        Map map = new HashMap();
        map.put("name","韦新阳");
        map.put("address", "地址");
        boolean add = new ArrayList<>().add(map.values());
        System.out.println(add);


    }
}
