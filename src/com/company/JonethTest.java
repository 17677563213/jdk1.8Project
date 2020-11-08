package com.company;

import org.junit.Before;
import org.junit.Test;

public class JonethTest {
/**
 * 构建1-41节点的循环链表
 *  思路:
 *      1.需要声明第一个节点(为了最后面的节点指回第一个节点,构建循环链表)
 *      2.采用whiile() 循环
 *      3.前面的节点的移动与指向
 */

    @Test
    public void method01(){
//       声明第一个节点
        CurrentNode first=null;
        CurrentNode preNode=null;
//        声明遍历的节点
        for (int i = 1; i <=41 ; i++) {

//            判断是否为第一个节点:
            if(i==1){
               first= new CurrentNode<Integer>(i,null);
               preNode=first;
               continue;//本次不需要再往下执行
            }else{
                CurrentNode<Integer> temporaryNode = new CurrentNode<>(i, null);
                preNode.next=temporaryNode;
                preNode=temporaryNode;
            }
//            如果不是第一个节点:
            if(i==41){
                preNode.next=first;
            }
        }


//        模拟自杀
//        定义计数器:
        int counter=0;
        CurrentNode node=first;
        CurrentNode pre=null;

//        表示不等于自己
        while(node!=node.next){
            counter++;
//            数到3,重置计数器,将前面的指向直接 当前后面节点
            if(counter!=3){
                pre=node;
                node=node.next;

            }else if(counter==3){
                pre.next=node.next;
                System.out.print(node.item+",");
                node=node.next;

//                打印自杀的数据:
                counter=0;

            }

        }
//        打印最后一个:
        System.out.println(node.item);










    }
  private class CurrentNode<T>{
        public T item;
        public CurrentNode next;

      public CurrentNode(T item, CurrentNode next) {
          this.item = item;
          this.next = next;
      }
  }

}
