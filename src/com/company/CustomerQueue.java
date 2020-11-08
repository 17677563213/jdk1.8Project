package com.company;


import org.junit.Test;

import java.util.Iterator;

/**
 * 知识点:
 *  队列特点:
 *      1.先进先出
 *      2.队列的实现可以通过链表或者时数组形式
 *
 * 需求:
 *  1.通过链表实现队列
 *
 * 思路:
 *  1.创建一个节点内部类
 *  2.队列成员变量:头部节点,尾部节点,元素个数
 *  3.提供方法:isEmpty(),enQueue(),delQueue(),getElementNum();
 */
public class CustomerQueue<T> implements Iterable{
    @Override
    public Iterator iterator() {

        return new Iterator() {
            Node temporaryNode=head;
            @Override
            public boolean hasNext() {
                return temporaryNode.next!=null;
            }

            @Override
            public Object next() {
                 temporaryNode = temporaryNode.next;
                return temporaryNode.item;
            }
        };
    }

    //内部类:节点
    private class Node<T> {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public Node head;
    public Node last;
    public int number;
    public CustomerQueue() {
        this.head=new Node(null, null);
        this.last=null;
        this.number=0;
    }
//    判断是否为空
    public boolean isEmpty(){
        return number==0;

    }
//    添加元素:
    public void enqueue(T e){
        if(isEmpty()){
            last=new Node(e,null);
            this.head.next=last;
            number++;
        }else{
//            Node<T> newLastNode = new Node<>(e, null);
//            last.next=newLastNode;
//            newLastNode.next=last;
//            number++;
            Node oldLast = this.last;
            Node<T> newLastNode = new Node<>(e, null);
            this.last =newLastNode;
            oldLast.next= newLastNode;
            number++;
        }
    }
//    移除元素:
    public T deQueue(){
        if(isEmpty()){
            return null;
        }
        Node deNode = this.head.next;
        this.head.next=deNode.next;
        if(deNode==null){
            return null;
        }
        number--;
        return (T) deNode.item;

    }
    public int getNumber(){
        return number;

    }

}



