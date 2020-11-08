package com.company;
import java.util.Iterator;

public class twoWayLink<T> implements Iterable {
    //    内部类
    private class Node<T> {
        //        该类成员变量:
        private Node pre;
        private T item;
        private Node next;

        //    提供有参构造--在创建对象时进行赋值
        public Node(Node pre, T item, Node next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    //   成员变量:
    private Node headNode;
    private Node lastNode;
    private int num;

    //双向链表初始化,头节点,尾节点设置
    public twoWayLink() {
        this.headNode = new Node(null, null, null);
        this.lastNode = null;
        this.num = 0;
    }
//    判断是否为空

    /**
     * 思路:
     * 1.判断元素个数是否为0
     */
    public boolean isEmpty() {
        return num == 0;
    }
//    清空链表:

    /**
     * 思路:
     * 1.将头节点的下节点指向置空
     * 2.尾部节点置空
     * 3.元素个数为0
     */
    public void clear() {
        this.headNode.next = null;
        this.lastNode = null;
        this.num = 0;
    }
//    获取头节点:

    /**
     * 思路:
     * 1.判断是否为空
     * 2.不为空情况下再获取
     *
     * @return
     */
    public T getFirstNode() {
        if (isEmpty()) {
            return null;
        } else {
            T item = (T) this.headNode.next.item;
            return item;
        }
    }

    /**
     * 获取最后一个节点
     * 思路:
     * 1.判断是否为空链表
     * 2.获取最后一个节点
     */
    public T getLastNode() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) this.lastNode.item;
        }
    }

    /**
     * 向双向链表添加元素
     * 思路:
     * 1.判断该链表是否为空
     * 2.通过nums进行判断
     * 3.如果是空
     */
    public void insert(T element) {
        if (isEmpty()) {
//            创建新节点:
            Node<T> newNode = new Node<>(headNode, element, null);
            lastNode = newNode;
            this.headNode.next = newNode;
        } else {
            Node temporaryNode = lastNode;
            Node<T> newNode = new Node<>(temporaryNode, element, null);
            temporaryNode.next = newNode;
            this.lastNode = newNode;
        }
        num++;
    }

    /**
     * 按照位置添加元素
     */
    public void insertElementByPosition(int position, T element) {
        Node temporaryNode = this.headNode;
//        position位置,前面节点
        for (int i = 0; i <= position - 1; i++) {
            temporaryNode = temporaryNode.next;
        }
//        position当前位置节点:
        Node currentNode = temporaryNode.next;
//        创建新节点:
        Node<T> newNode = new Node<>(temporaryNode, element, currentNode);
        temporaryNode.next = newNode;
        currentNode.pre = newNode;
        num++;
    }

    //    获取某个位置元素:
    public T getElementByPosition(int position) {
        Node temporary = this.headNode;
        for (int i = 0; i <= position; i++) {
            temporary = temporary.next;
        }
        return (T) temporary.item;
    }

    //  获取第一个element元素位置:
    public int getPositionByFirstElement(T element) {
        Node temporaryNode = this.headNode;
        for (int i = 0; temporaryNode.next != null; i++) {
            temporaryNode = temporaryNode.next;
            if (temporaryNode.item.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //    移除某个位置元素:
    public T removeElementByPosition(int position) {
        Node temporaryNode = this.headNode;
//        position前面节点
        for (int i = 0; i <= position - 1; i++) {
            temporaryNode = temporaryNode.next;
        }
//        当前节点:
        Node currentNode = temporaryNode.next;
//        当前位置后面节点:
        Node currentNextNode = currentNode.next;
        temporaryNode.next = currentNextNode;
        currentNextNode.pre = temporaryNode;
        num--;
        return (T) currentNode.item;
    }

    //    获取元素个数:
    public int getElementNum() {
        return this.num;
    }

    //    遍历:
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node temporaryNode = headNode;

            @Override
            public boolean hasNext() {
                return temporaryNode.next != null;
            }

            @Override
            public Object next() {
                temporaryNode = temporaryNode.next;
                return temporaryNode.item;
            }
        };
    }
}
