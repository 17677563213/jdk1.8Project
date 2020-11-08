package com.company;

import java.lang.reflect.Method;

public class TestAnnotation {
    @MyAnnotation("广西科技师范学院")
    public void show(){


    }

    public static void main(String[] args) throws NoSuchMethodException {
//        获取字节码,也就是反射的形式
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");
        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
//
        /**
         * 自定义注解:
         * 的步骤:
         * 1.创建类型@interface
         * 2.在类的上面添加元注解
         * 3.基于Java反射机制,获取字节码对象,通过字节码对象,获取到对应的方法,在通过该方法获取到该方法上的注解
         */



    }
}
