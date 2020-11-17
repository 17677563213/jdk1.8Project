package com.company;

public class Head<T extends  Comparable<T>> {
    private T item [];

    private int N;


//    构造方法

    public Head(int capacity) {
        this.item= (T[]) new Object [capacity];
    }

    public boolean compable(int a,int b){
        return item[a].compareTo(item[b])<0;
    }
//    替换指定的两个位置数据


    public void changePosition(int a,int b){
        T tempolation=item[a];
        item[a]=item[b];
        item[b]=tempolation;

    }



}
