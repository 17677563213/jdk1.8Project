package com.company;

import org.junit.Test;

import java.util.Comparator;

public class Priority<T extends  Comparable<T>> {
    private T [] item;
    private int N;
    //构造
    public Priority(int capacirty) {
        this.N=0;
        this.item= (T[]) new Comparable [capacirty+1];
    }
    //是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //元素个数
    public int getElementNumber(){
        return N;
    }
    //添加元素:
    public void insert(T elemnt){
        this.item[++N]=elemnt;
        //调整元素
        swin(N);

    }
    //删除最大元素:
    public T delMax(){
        T delReuslt = this.item[1];
        changePosition(1, N);
        --N;
        sink(1);
        return delReuslt;
    }
    //比较
    public boolean comparable(int position1,int position2){
        return this.item[position1].compareTo(this.item[position2])<0;
    }
    //交换位置:
    public void changePosition(int position1,int position2){
        T tem=this.item[position1];
        this.item[position1]=this.item[position2];
        this.item[position2]=tem;
    }
    //上浮
    public void sink(int position){
        //限制条件:
        while(position*2<=N){
            int maxIndex;
            //判断是否存在右节点:
            if(position*2+1<=N){
                //获取最大值:
                if(comparable(position*2, position*2+1)){
                    maxIndex=position*2+1;
                }else{
                    maxIndex=position*2;
                }
            }else{
                    maxIndex=position*2;
            }
            if(!comparable(position, maxIndex)){
                break;
            }else{
                changePosition(position, maxIndex);
                position=maxIndex;
            }
        }
    }
    public void swin(int position){
        while(position>1){
            if(comparable(position, position/2)){
                break;
            }else{
                changePosition(position, position/2);
                position=position/2;
            }
        }
    }
}
