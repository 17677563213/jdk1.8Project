package com.company;

import com.company.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Review01 {
    List<Employee> employees = Arrays.asList(new Employee("小肥羊", "男", 2000),
            new Employee("旺财", "男", 6000),
            new Employee("二当家", "男", 5000),
            new Employee("小灰灰", "女", 4000),
            new Employee("海虹", "女", 2200)
    );
    @Test
    public void method01(){

//        过滤需要满足提交的情况下才能够被输出 ,需要参数,返回一个结果
        Stream<Employee> results = employees.stream().filter(e -> e.getName().contains("当家"));
        results.forEach(System.out::println);
//        知识点:contains :包含内容
//        将集合中的元素的对象名称全部获取到,获取到之后再将其将名字连接起来,通过斜线的形式
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
//        emp 收集:显示级别类型
        String collect1 = employees.stream().map(Employee::getName).collect(Collectors.joining("/"));
        System.out.println(collect1);

        }


        /**
         * 中间操作
         *
         * filter： 过滤流，过滤流中的元素，返回一个符合条件的Stream
         *
         * map： 转换流，将一种类型的流转换为另外一种流。（mapToInt、mapToLong、mapToDouble 返回int、long、double基本类型对应的Stream）
         *
         * flatMap：简单的说，就是一个或多个流合并成一个新流。（flatMapToInt、flatMapToLong、flatMapToDouble 返回对应的IntStream、LongStream、DoubleStream流。）
         *
         * distinct： 返回去重的Stream。
         *
         * sorted： 返回一个排序的Stream。
         *
         * peek： 主要用来查看流中元素的数据状态。
         *
         * limit： 返回前n个元素数据组成的Stream。属于短路操作
         *
         * skip： 返回第n个元素后面数据组成的Stream。
         */



    @Test
    public void method02() {
        //        将集合中的元素进行分组(按照员工的状态进行分组)
        Map<String, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getSex));
        System.out.println(collect2.toString());


        Set<String> strings = collect2.keySet();
        for (String string : strings) {
            System.out.println("键:" + string + "    value: " + collect2.get(string));


        }
//        知识点:遍历map类型的方式:先获取到map的key,在通过遍历key,获取到map对应的value;
//        filter,map,collect,group by,
//
//        收集工具类涉及到的方法:
        /**
         *

         //总数
         Long sum = employees.stream()
         .collect(Collectors.counting());

         //平均值
         Double avgSalary = employees.stream()
         .collect(Collectors.averagingDouble(Employee::getSalary));

         //总和
         Double sumSalary = employees.stream()
         .collect(Collectors.summingDouble(Employee::getSalary));

         //最大值
         Optional<Employee> op1 = employees.stream()
         .collect(Collectors.maxBy((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())));

         */

        /**
         * 1.collects.joinning() :在元素之间拼接内容
         * 2.collects.toList():将元素变成指定集合
         * 3.collects.group by:将元素进行分组,填写分组的标准
         * 4.collects.count():统计元素的总数
         * 5.collects.max()计算元素中的最大值,需要传递统计的是什么元素
         * 6.collects.min()
         */
    }
}
