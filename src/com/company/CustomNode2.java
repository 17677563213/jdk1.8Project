package com.company;
import java.util.Iterator;
public class CustomNode2<T>  implements  Iterable{
    //    内部类
    private static class Node<T> {
        private T item;
        private Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    // 头部节点
    private Node head;
    // 节点个数:
    private int num;
    //    构造方法()
    public CustomNode2() {
        this.head = new Node(null, null);
        this.num = 0;
    }
    //    清空链表--将头节点指向中断
    public void clearLink() {
        this.head.next = null;
        this.num = 0;
    }
    /**
     * 在尾部添加节点
     * 思路:
     * 1.创建一个临时变量存储头节点指向下一个节点
     * 2.采用while()进行遍历
     * 3.将之前的未节点指向添加元素
     * 注意:
     * 添加元素不是添加整个节点
     */
    public void insertNodeOnTail(T element) {
        Node temporaryNode = this.head;
        while (temporaryNode.next != null) {
            temporaryNode = temporaryNode.next;
        }
        Node<T> tNode = new Node<>(element, null);
        temporaryNode.next = tNode;
        num++;
    }
    /**
     * 获取某一个位置元素:
     * 思路:
     * 1.获取头节点
     * 2.采用while()进行遍历
     */
    public T getItemByPosition(int position) {
        Node temporaryNode = this.head.next;
        for (int i = 0; i < position; i++) {
            temporaryNode = temporaryNode.next;
        }
        T item = (T) temporaryNode.item;
        num++;
        return item;
    }
//    在某一个位置添加元素
    /**
     * 思路:
     *  1.获取头节点
     *  2.遍历
     *  3.获取该位置前面节点,后面节点
     *  4.修改他们之间指向
     */
    public void  insertElementByPosition(int i ,T element){
        Node temporaryNode=head;
//        i位置前面的节点
        for (int j = 0; j <=i-1 ; j++) {
            temporaryNode = temporaryNode.next;
        }
//        i位置节点:
        Node currentNode = temporaryNode.next;
        Node<T> tNode = new Node<>(element, currentNode);
        temporaryNode.next=tNode;
        num++;
    }
    /**
     * 移除某一个位置中的元素:
     * 思路:
     *  跟添加元素一样
     */
    public T removeElementByPosition(int position){
        Node temporaryNode=head;
        for (int i = 0; i <=position-1 ; i++) {
            temporaryNode=temporaryNode.next;
        }
//        position位置节点:
        Node currentNode = temporaryNode.next;
//        postion位置后面节点:
        Node lastNode = currentNode.next;
        temporaryNode.next=lastNode;
         T item = (T)currentNode.item;
         num--;
        return  item;
    }
    /**
     * 迭代
     * @return
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node temporary=head;
            @Override
            public boolean hasNext() {
                return temporary.next!=null;
            }
            @Override
            public Object next() {
                temporary=temporary.next;
                return temporary.item;
            }
        };
    }
    /**
     * 问题:
     *  1.自己对Java的常用api还是不够了解
     *  2.手动实现一个链表的思路:
     *      a.类中的元素:头部节点;创建一个内部类节点类Node(Node next;T item)
     */
    public void reserve(){
        if(isEmpty()){
            try {
                throw  new Exception("链表不能为空!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        reserve(head.next);
    }

    /**
     * 反转
     *  思路:
     *      1.采用递归方式
     *      2.递归跳出条件判断是否是最后一个元素,如果是最后一个元素,需要将头部节点下一个元素指向该元素
     *      3.返回元素就是需要反转的节点
     *
     *  总结:
     *      1.整体来讲就是修改每一个元素的next指向
     * @param currentNode
     * @return
     */
    public Node reserve(Node currentNode){
        if(currentNode.next==null){
            this.head.next=currentNode;
            return currentNode;
        }
        Node nextNode = reserve(currentNode.next);
        nextNode.next=currentNode;
        currentNode.next=null;
        return currentNode;
    }

    public boolean isEmpty(){
        return num==0;
    }
//    单链表应用:快慢指针用来快速查找链表中间的元素
    public String getMiddleNode(){
        Node<String> fast=this.head;
        Node<String> slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        return slow.item;
    }
//    判断链表中是否存在环形连入口:
    /**
     * 思路:
     *  1.需要利用快慢指针
     *  2.当快慢指针相遇时,创建一个临时节点指向头部节点,随后开始遍历
     *  3.当临时节点与慢节点相遇时,当前的节点就是环形入口
     * @param first
     */
    public static CustomNode getCircleLinkEntrance(CustomNode<String> first){
//        声明快慢节点:
        CustomNode<String> fast=first;
        CustomNode slow=first;
        CustomNode temporaryNode=null;
          while (fast.next!=null){
              fast=fast.next.next;
              slow=slow.next;
              if(fast==slow){
                  temporaryNode=first;
                  continue;

              }
              if(temporaryNode!=null){
                  temporaryNode=temporaryNode.next;

              }
              if(temporaryNode==slow){
                return temporaryNode;
              }




          }
          return null;


    }
}
