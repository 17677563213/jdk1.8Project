package com.company;

import java.util.Iterator;
import java.util.Objects;

public class SequenList<T> implements  Iterable<T> {
    public  T[] currentArraylist;
//    元素个数
    private Integer size;
//    容器容量:
    private Integer capacity;

//    创建容器的时候,自定义容量大小
    public SequenList(int capacity ) {
      this.currentArraylist= (T[]) new Object [capacity];
      this.size=0;
      this.capacity=capacity;
    }
//    添加元素:
    public void  insert(T parameter){
        if(size>=currentArraylist.length){
            resize(size.intValue()*2);

        }
        this.currentArraylist[size++]=parameter;
    }



    //按照位置添加元素:
    public void insert(int position ,T parameter) throws Exception {
        if(size>=currentArraylist.length){
            resize(size.intValue()*2);

        }
//        1.获取对应位置下的元素,该位置后面的元素都需要往后移动
        if(position>size){
            throw new Exception("数组越界");
        }
        T t = currentArraylist[position];
        for (int i = size; i >position ; i--) {
            currentArraylist[i]=currentArraylist[i-1];

        }
        currentArraylist[position]=parameter;
        size++;

    }

//    判断该顺序表是否为空:
    public boolean isEmpty(){
        return size==0;
    }
//    移除某一个位置的元素:
    public T   removeByPosition(int position){
        T removeContent = currentArraylist[position];
//        移动后面的内容往前:
        for (int i = position; i <size-1 ; i++) {
            currentArraylist[position]=currentArraylist[position+1];

        }
        size--;
        return  removeContent;
//
    }
//  清空该集合:

    public void clear (){
        currentArraylist= (T[]) new Objects[0];
        this.capacity=0;
        size=0;
    }
//获取某一个位置元素:
    public T getElementByPosition(int position) throws Exception {
        if(position>size){
            throw  new Exception("数组越界");
        }
        T t = currentArraylist[position];
        return t;

    }

    public int getLength(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current;

            @Override
            public boolean hasNext() {

                return current<size;
            }

            @Override
            public T next() {
//            获取之后自动++
                return currentArraylist[current++];
            }
        };
    }

    private class customIterator implements  Iterator{

        private int current;

        @Override
        public boolean hasNext() {

            return current<size;
        }

        @Override
        public Object next() {
//            获取之后自动++
            return currentArraylist[current++];
        }
//        扩容思路:
        /**
         * 1.保存原来的对象
         * 2.创建新的对象内存地址指向原来
         * 3.遍历将之前的集合的元素赋值给新的容器
         */

    }

    public void resize(int newCapacity){
        T [] newCurrentArraylist=currentArraylist;
        currentArraylist= (T[]) new Object[newCapacity];
        for (int i = 0; i <newCurrentArraylist.length ; i++) {
            currentArraylist[i]=newCurrentArraylist[i];

        }

    }
}
