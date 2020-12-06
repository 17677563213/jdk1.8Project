package com.company;

import org.junit.Test;

public class Test08 {
    @Test
    public void methd01(){
        int N=8;
        int h=1;
        while(h<N/2){
            h=2*h+1;
        }
        System.out.println(h);

    }
}
