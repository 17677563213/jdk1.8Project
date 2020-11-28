package com.company;

import org.junit.Test;

import java.util.LinkedList;

public class DeptFirstSearchTest {

    @Test
    public void method01(){
        //构造图
        /**
         * 1.添加节点
         * 2.将两个点连接起来
         */
        Graph graph = new Graph(13);
        graph.connetTwoSpot(0, 5);
        graph.connetTwoSpot(0, 1);
        graph.connetTwoSpot(0, 2);
        graph.connetTwoSpot(0, 6);
        graph.connetTwoSpot(5, 3);
        graph.connetTwoSpot(5, 4);
        graph.connetTwoSpot(4, 3);
        graph.connetTwoSpot(6, 4);





        //测试深度优先遍历
        DeptFirstSearch deptFirstSearch = new DeptFirstSearch(graph, 0);


        //测试预定点是否相连
        System.out.println("与顶点相连个数:"+deptFirstSearch.getConnectNumber());

        //测试与顶点相连个数:
        System.out.println("顶点0是否与点5相连"+deptFirstSearch.isConnect(5));
        System.out.println("顶点0是否与点7相连"+deptFirstSearch.isConnect(5));
    }

    @Test
    public void method02(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.offer(1);
        list.offer(1);
        list.peek();
        list.poll();
        list.push(1);
    }


    /**
     * Java中 linkList中常用接口:
     * 1. offer():将元素放到最后面
     * 2. peek():获取该链表的头元素
     * 3.
     */
}
