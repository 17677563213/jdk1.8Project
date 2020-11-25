package com.company;

import org.junit.Test;

public class SequenceList02Test {
    @Test
    public void method01(){
        SequenceList02<String> sequent = new SequenceList02<>(10);
        sequent.insert("阿里巴巴");
        sequent.insert("字节跳动");
        sequent.insert("拼多多");
        sequent.insert(2,"华为");

        for (String s : sequent) {
            System.out.println(s);
        }
        System.out.println(sequent.getPositionByElement("华为"));
        System.out.println(sequent.del(0));
        System.out.println("--------------------------");
        for (String s : sequent) {
            System.out.println(s);
        }





    }


}
