package com.company;

public class TwoWayLinkNodeTest {
    /**
     * 注意:
     *  类中私有的变量,不能够通过对象进行调用,背private修饰的变量只能够被该类内部进行使用
     * @param args
     */
    public static void main(String[] args) {
        twoWayLink<String> stringtwoWayLink = new twoWayLink<>();
        stringtwoWayLink.insert("阿里巴巴");
        stringtwoWayLink.insert("京东");
        stringtwoWayLink.insert("蘑菇街");
        stringtwoWayLink.insert("字节跳动");
        stringtwoWayLink.insertElementByPosition(1, "百度");
        for (Object o : stringtwoWayLink) {
            System.out.println(o);
        }
        System.out.println("元素个数 : "+stringtwoWayLink.getElementNum());

        String s = stringtwoWayLink.removeElementByPosition(1);
        System.out.println("删除元素 : "+s);
        System.out.println("删除之后进行遍历----------------------");
        for (Object o : stringtwoWayLink) {
            System.out.println(o);
        }
        stringtwoWayLink.insert("京东");
        System.out.println("----------------------0000000000000000000----------------");
        for (Object o : stringtwoWayLink) {
            System.out.println(o);
        }
        System.out.println("////////////");
        String result1 = stringtwoWayLink.getElementByPosition(1);
        System.out.println(result1);
        int position = stringtwoWayLink.getPositionByFirstElement("京东");
        System.out.println("位置 : "+position);
        stringtwoWayLink.clear();
        System.out.println("元素个数 : "+stringtwoWayLink.getElementNum());
        for (Object o : stringtwoWayLink) {
            System.out.println("清空之后 : "+o);
        }
    }
}
