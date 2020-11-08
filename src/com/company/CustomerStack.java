package com.company;

import java.util.Iterator;

public class CustomerStack<T> implements  Iterable {
//    成员变量:
//    头节点
    public Node head=new Node(null, null);;
//    public CustomerStack() {
//          this.head=new Node(null, null);;
//    }


    public int N;
//    判断是否为空
    public boolean isEmpty(){
        return N==0;

    }
//    获取元素个数:
    public Integer getElementNum(){
        return N;
    }
//    压栈(添加元素)
    public void push(T element){
        /**
         * 思路:
         *  1.创建一个新元素
         *  2.获取头节之前所指的元素
         *  3.头节点元素指新节点
         */
        Node<T> newFirstNode = new Node<T>(null, element);
        Node oldFirstNode = head.next;
        head.next=newFirstNode;
        newFirstNode.next=oldFirstNode;
        N++;

    }
//    出栈
    public T pop(){
        /**
         * 思路:
         *  1.获取头节点所指元素
         *  2.将所获取元素再获取下一个节点
         */
        Node oldNode = head.next;
        if(oldNode==null){
//            表示最后一个没有了
            return null;
        }
        head.next=oldNode.next;
        N--;
        return (T) oldNode.item;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
//            声明一个变量用于从头部开始
            Node currNode=head;
            @Override
            public boolean hasNext() {
                return currNode.next!=null;
            }

            @Override
            public Object next() {
                currNode = currNode.next;
                return currNode.item;
            }
        };
    }


    private class Node<T>{
        public Node next;
        public T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

}
