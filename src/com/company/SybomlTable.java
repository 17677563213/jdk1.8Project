package com.company;

import com.sun.xml.internal.ws.spi.db.OldBridge;

public class SybomlTable<Key,Value> {
    private class Node<Key,Value> {
        public Key key;
        public Value value;
        public Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private Integer number;

    public SybomlTable() {
        this.head = new Node(null, null, null);
        this.number = 0;
    }

    public void  put(Key key,Value value){
//        判断是否存在重复的key
        Node n=head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                n.next.value=value;
                return;
            }
            n=n.next;
        }
        Node oldFirst = head.next;
        Node<Key, Value> newNode = new Node<>(key, value, null);
        head.next=newNode;
        newNode.next= oldFirst;
        number++;


    }
    public Value getElement(Key key){
        Node n=head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                return (Value) n.next.value;
            }
            n=n.next;
        }

        return null;

    }

    public Value delElement(Key key){
        Node node = this.head;
        while (node.next!=null){
            if(node.next.key.equals(key)){
                Node delNode = node.next;
                node.next=node.next.next;
                return (Value) delNode.value;

            }
            node=node.next;
            number--;

        }
        return null;
    }
    public Integer getNumber(){

        return number;
    }

}
