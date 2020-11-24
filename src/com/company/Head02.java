package com.company;

import java.util.Comparator;

public class Head02<T extends  Comparable<T>> {
    private T [] item;
    private int n;
//构造方法初始化
    public Head02(int capacity) {
        this.item= (T[]) new Comparable [capacity+1];
    }
//    判断两个位置元素大小
    public boolean compable(int position1,int position2){
        return this.item[position1].compareTo(this.item[position2])<0;
    }
//    交换两个位置的元素:
    public void changePosition(int position1,int position2){
        T temporaty=this.item[position1];
        this.item[position1]=this.item[position2];
        this.item[position2]=temporaty;
    }
//    添加元素:
    public void  insert(T element){
        this.item[++n]=element;
//        调整元素(大的元素上浮)
        swin(n);
    }
    public T delMax(){
        T delResult=this.item[1];
        changePosition(1, n);
        this.item[n]=null;
//        调整元素位置(元素下沉)
        n--;
        sink(1);
        return  delResult;

    }
    public void sink(int position){
        while(position*2<=n){
            int max;
//            判断是否存在右节点:
            if(position*2+1<=n){
                if(compable(position*2, position*2+1)){
                    max=position*2+1;
                }else{
                    max=position*2;
                }
//                不存在右节点
            }else{
                max=position*2;
            }
            if(compable(position, max)){
                changePosition(position, max);
            }else{
                break;
            }
            position=max;




        }



    }


    public void swin(int position){
        while(position>1){
            if(compable(position/2, position)){
                changePosition(position/2, position);
            }
            position=position/2;



        }


    }



}
