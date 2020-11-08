package com.company;

import org.junit.Test;

public class SequentListTest {
    public static void main(String[] args) throws Exception {
        SequenList<String> stringSequenList = new SequenList<>(10);
        stringSequenList.insert("阿里巴巴");
        stringSequenList.insert("京东");
        stringSequenList.insert("华为");
        stringSequenList.insert("字节跳动");

        try {
            stringSequenList.insert(3, "百度");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        问题:为什么可以通过这种遍历的方式进行
        for (int i = 0; i <stringSequenList.getLength() ; i++) {
            try {
                String elementByPosition = stringSequenList.getElementByPosition(i);
                System.out.println(elementByPosition);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("获取到的结果 : "+stringSequenList.getElementByPosition(4));
        System.out.println(("判断是否为空 : " + stringSequenList.isEmpty()));
        for (String s : stringSequenList) {
            System.out.println("增强for的操作");
            System.out.println(s);
        }
//        stringSequenList.clear();
//        System.out.println("测试容器是否成功置为空"+stringSequenList.getLength());
//        Object[] currentArraylist = stringSequenList.currentArraylist;
//        for (int i = 0; i <currentArraylist.length ; i++) {
//            System.out.println("容器没有为空!!");
//        }

    }
//    原来增强for循环是这样的操作:
    /**
     * 思路:
     *  1.自己的类需要继承一个iterable的接口,实现其重的接口
     *  2.匿名内部类: 需要hasnext() next()获取下一个内容;
     */
    @Test
    public void method01(){
        SequenList<String> objects = new SequenList<>(2);
        objects.insert("java");
        objects.insert("javaScript");
        objects.insert("javaEE");
        objects.insert("javaSE");
        for (String object : objects) {
            System.out.println(object);
        }

    }
    /**
     * 顺序表设计内容的方法:
     * 1.元素:数组 Arraylist采用的是object的数组,自己实现的方式采用的是泛型模式
     * 2.数组中元素的个数
     *
     * 涉及到的方法:
     * 1.构造方法:指定容器的大小
     * 2.添加元素方法:insert(T parameter) insert(int position,T parameter)
     * 3.获取某一个位置元素:getElementByPosition(int position)
     * 4.清空数组:clear()
     * 5.扩容方法
     * 6.获取元素方法:remove(int position)
     */
}
