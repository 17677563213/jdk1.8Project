package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void method03(){
        String str="bcabc";
        String[] split = str.split("");
        List<String> collect = Arrays.stream(split).distinct().collect(Collectors.toList());
        StringBuffer stringBuffer = new StringBuffer();

        for (String s : collect) {
            stringBuffer.append(s);
        }
        System.out.println(stringBuffer.toString());
    }


    @Test
    public void method04(){
        int [] number1={1,2,3};
        int [] number2={3,2,1};
        System.out.println(validateStackSequences(number1, number2));

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length){
            return false;

        }
        StringBuffer stringBuffer1 = new StringBuffer();
        for (int i = 0; i <pushed.length ; i++) {
            stringBuffer1.append(pushed[i]);

        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = popped.length-1; i >=0; i--) {
            stringBuffer.append(popped[i]);
        }
        Object o = new Object();
        Integer integer = new Integer(1);
        integer= (Integer) o;

        return stringBuffer1.toString().equals(stringBuffer.toString());





    }

    @Test
    public void method005(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }


        Integer [] ints ={1,3,5};
        Arrays.sort(ints);


    }


    /**
     * Java中 linkList中常用接口:
     * 1. offer():将元素放到最后面
     * 2. peek():获取该链表的头元素
     * 3.
     */
}
