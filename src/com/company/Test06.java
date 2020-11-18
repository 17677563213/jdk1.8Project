package com.company;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetException;
import org.junit.Test;

public class Test06 {

    public static void main(String[] args) {
        Integer num1=4;
        Integer num2=6;
        System.out.println(num1.compareTo(num2)<0);


    }
    @Test
    public void method04(){
        System.out.println(isPowerOfFour(17));
    }
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }

        while (n>=4) {
            int num1=0;
            int num2=0;


            num1=n/4;
            num2=n%4;
            if(num1==1&&num2==0){
                return true;

            }
            n=num1;

        }
        return false;
    }

    @Test
    public void method07(){
        double pow = Math.pow(4, 2);
        System.out.println(pow);


    }
}
