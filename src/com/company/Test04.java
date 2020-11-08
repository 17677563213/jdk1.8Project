package com.company;

public class Test04 {
    public static void main(String[] args) {
        CustomNode2<String> stringCustomNode2 = new CustomNode2<>();
//        在链表的尾部添加元素测试
        stringCustomNode2.insertNodeOnTail("阿里巴巴");
        stringCustomNode2.insertNodeOnTail("京东");
        stringCustomNode2.insertNodeOnTail("字节跳动");
        stringCustomNode2.insertNodeOnTail("蘑菇街");
//        在链表任意位置添加元素
        stringCustomNode2.insertElementByPosition(1, "百度");
        for (Object o : stringCustomNode2) {
            System.out.println(o);
        }
        System.out.println("获取中间元素 : "+stringCustomNode2.getMiddleNode());


        System.out.println("下面是链表反转之后结果");
       stringCustomNode2.reserve();
        for (Object o : stringCustomNode2) {
            System.out.println(o);
        }


    }
}
