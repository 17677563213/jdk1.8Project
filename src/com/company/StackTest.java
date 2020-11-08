package com.company;

import org.junit.Test;

public class StackTest {

    @Test
    public void test01(){
        CustomerStack<String> customerStack = new CustomerStack<>();
        customerStack.push("a");
        customerStack.push("b");
        customerStack.push("c");
        customerStack.push("d");
//        迭代:
        for (Object item : customerStack) {
            System.out.println(item);
        }
        System.out.println("元素个数: "+customerStack.getElementNum());
        String pop = customerStack.pop();
        System.out.println("这是出栈元素: "+pop);
        System.out.println("目前元素个数: "+customerStack.getElementNum());

        /**
         * 所犯错误:
         *  1.对于Java应用的基本数据类型,自己需要进行初始化值,
         *  2.基本数据类型默认有自己数据
         *
         *  总结:
         *  1.采用链表模拟栈,添加元素,移除元素的过程
         *  2.类中包含元素:
         *          1.第一个元素
         *          2.元素个数
         *     设置方法:
         *          1.添加元素
         *          2.移除元素
         *          3.判断栈是否为空
         *          4.获取栈中元素个数
         *
         */


    }
    @Test
    public void method02(){

        String str="(((广西)))";
        char[] chars = str.toCharArray();
        int leftNumber=0;
        int rightNumber=0;
        for (int i = 0; i <chars.length ; i++) {
            if("(".equals(chars[i]+"")){
                leftNumber++;
            }
            if(")".equals(chars[i]+"")){
                rightNumber++;
            }
        }
        System.out.println("字符串中括号是否正对出现: "+(leftNumber==rightNumber));

    }
    @Test
    public void method03(){
//        每一个中文汉字就是一个字符
//        获取单个字符方法:
//
        String string = "广西科技师范学院";
        for (int i = 0; i <string.length() ; i++) {
            System.out.println(string.charAt(i)+"");
        }

    }

    /**
     * 需求:
     *      1.利用栈实现对字符串中括号是否成对匹配
     * 思路:
     *      1.遍历字符串
     *      2.如果遇到左括号添加到栈中
     *      3.判断是否是右括号,如果时从栈中移除一个左括号,判断移出来是否是为空,如果为空表示
     *      4.最后面判断栈中元素的个数
     *
     *
     */
    @Test
    public void method04(){


    }

}
