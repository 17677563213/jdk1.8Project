package com.company;

public class HeadSort<T extends  Comparable<T>> {

//    比较
    public static boolean compare(Comparable [] head,int p1,int p2){
       return  head[p1].compareTo(head[p2])<0;
    };

//    替换

    public static void changePosition(Comparable [] head,int p1,int p2){
        Comparable tem=head[p1];
        head[p1]=head[p2];
        head[2]=tem;

    }

}
