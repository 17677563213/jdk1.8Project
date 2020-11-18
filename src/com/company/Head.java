package com.company;

public class Head<T extends Comparable<T>> {
    private T item[];

    private int N;


//    构造方法

    public Head(int capacity) {
        this.item = (T[]) new Comparable[capacity+1];
    }

    public boolean compable(int a, int b) {
        return item[a].compareTo(item[b]) < 0;
    }//    替换指定的两个位置数据
    public void changePosition(int a, int b) {
        T tempolation = item[a];
        item[a] = item[b];
        item[b] = tempolation;
    }
    public void insert(T t){
//        添加元素
       item[++N]=t;

//        调整元素位置,元素上浮
        swin(N);

    }

    public void swin(int position){
        while(position>1){
            if(compable(position/2, position)){
                changePosition(position/2, position);
                position=position/2;
            }
        }
    }


    public T deMax(){
//        获取最大元素:
        T t = item[1];
//        交换位置:
        changePosition(1, N);
        item[N]=null;
        --N;
        sink(1);
        return t;
//        调整元素位置:
    }

    public void sink(int position){
//        保证不越界
        while(position*2<=N){
            int max=0;
//            判断存在右边节点
            if((position*2+1)<=N){
                if(compable(position*2, position*2+1)){
                    max=position*2+1;
                }else{
                    max=position*2;
                }
            }else{
                max=position*2;
            }
//            与当前节点进行比较:
            if(!compable(position, max)){
                break;
            }
            changePosition(max, position);

            position=max;
        }
    }
}
