package com.company;

/**
 * 手写一个线性表添加,删除,获取元素个数,
 * 添加有两种方式,一种是直接添加在元素的尾部,添加到指定位置
 * 删除也有两种情况,第一种直接删除最后一个元素,第二种是指定位置在进行删除
 *
 * @param <T>
 */
public class SequenceList02<T> {
    private T [] item;
    private int n;

    public SequenceList02(int capocity) {
        this.n = 0;
        this.item= (T[]) new Object[capocity];
    }

//    判断该线程是否为空
    public boolean isEmpty(){
        return n==0;
    }

//    获取元素个数:
    public int getNumberElment(){
        return this.n;
    }
    public void setEmpty(){
        this.n=0;
        this.item=null;
    }
//    添加元素
    public void insert(T element){
        if(n==this.item.length){
            throw  new RuntimeException("空间已满,不可再添加");
        }
        this.item[n++]=element;
    }
//    按照某一个位置添加元素:
    public void insert(int position,T element){
//        先判断是否可以添加元素
        if(position==this.item.length){
            throw  new RuntimeException("空间已满,不可在添加元素");
        }
//        判断插入的元素位置是否合法
        if(position<0||position>this.item.length){
            throw new RuntimeException("插入元素位置不合法");
        }
//        对于添加元素,该元素位置后面都需要往后移动
        for (int i = this.n+1; i >position ; i--) {
            this.item[i]=this.item[i-1];

        }
//        将position的位置设置元素:
        this.item[position]=element;
        n++;
    }

//    移除某个位置上的元素:
    public T del(int position ){
//        判断删除元素的位置是否合法:
        if(position<0||position>this.item.length){
            throw  new RuntimeException("删除元素的位置不合法");
        }
        T t = this.item[position];
        n--;
        for (int i = position; i <n ; i++) {
            this.item[i]=this.item[i+1];
        }
        return t;
    }
    public int getPositionByElement(T element){
        for (int i = 0; i <n ; i++) {
            if(element.equals(this.item[i])){
                return i;
            }


        }
        return -1;

    }



}
