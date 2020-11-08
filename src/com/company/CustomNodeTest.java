package com.company;

import org.junit.Test;

import javax.lang.model.element.NestingKind;

public class CustomNodeTest {
    @Test
    public void method01(){
//        创建节点:
        CustomNode<String> first = new CustomNode<>("阿里巴巴", null);
        CustomNode<String> secord = new CustomNode<>("京东", null);
        CustomNode<String> third= new CustomNode<>("百度", null);


//        将节点连接起来形成单向链表:
        first.next=secord;
        secord.next=third;
        third.next=secord;


        CustomNode circleLinkEntrance = CustomNode2.getCircleLinkEntrance(first);
        System.out.println("循环路口"+circleLinkEntrance.item);


    }

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode pre = new ListNode(0) ;
        ListNode currentNode=pre;
        int carry=0; //通过除法
        int standard=0;
        while (listNode1!=null||listNode2!=null){
            int val =listNode1==null ? 0: (int) listNode1.val;
            int val2 =listNode2==null ? 0: (int) listNode2.val;
            int sum=val+val2+carry;
            carry=sum/10;
            standard=sum%10;
            if(listNode1!=null){
                listNode1=listNode1.next;
            }
            if(listNode2!=null){
                listNode2=listNode2.next;
            }
            ListNode temporary = new ListNode(standard);
            currentNode.next=temporary;
            currentNode=currentNode.next;
        }
        if(carry==1){
            ListNode listNode = new ListNode(1);
            currentNode.next=listNode;
        }
        return pre.next;

    }


}
