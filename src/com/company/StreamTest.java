package com.company;

import com.company.entity.Employee;
import com.sun.org.apache.xerces.internal.util.Status;
import org.junit.Test;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        数据元:数组,集合
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6, 7, 8);
//        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()){
//            System.out.println("新的迭代方式!");
//            System.out.println(iterator.next());
//        }
//        Stream<Integer> stream = numbers.stream();
//        Stream<Integer> integerStream = stream.filter((e) -> {
//            System.out.println("中间是否会被执行");
//            return e > 4;
//        });
//        Iterator<Integer> iterator1 = integerStream.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//
        /**
         * 总结:遍历的第二种方式
         */
        Integer [] intes={1,2,46,7};
        Stream<Integer> stream = Arrays.stream(intes);


    }
    @Test
    public void test01(){
        /**
         * 流的常用操作:
         * 1.过滤filter()
         * 2.skip() 跳过
         * 3.limit() 限制与skip()是相对的
         * 4.distint() 去掉重复的,注意这里面需要重写hashCode() 和equal()
         * 5.字符串变成字节数组的形式
         *
         *
         *
         *
         * 知识点:
         *  1.遍历的方式 iterator() ,结合while()一起使用 hashNext() :是否还存在下一个 next():获取结果
         */
//        将集合转化成流的形式:
        Stream<Employee> stream = employees.stream();
//        流的类型是String
        Stream<String> stringStream = stream.map(Employee::getName);
//        遍历流:
        stringStream.forEach(System.out::println);



    }

    List<Employee> employees = Arrays.asList(new Employee("小肥羊", "男", 2000,Employee.Status.BUSY),
            new Employee("旺财", "男", 6000, Employee.Status.BUSY),
            new Employee("二当家", "男", 5000, Employee.Status.FREE),
            new Employee("小灰灰", "女", 4000,Employee.Status.VACATINO),
            new Employee("海虹", "女", 2200,Employee.Status.FREE)
    );
    @Test
    public void test02(){
        List<String> strings = Arrays.asList("abc", "abxx", "www");
        String [] objects = (String[]) strings.toArray();
    }

    /**
     * 将字符串变成字符数组,遍历,再将元素添加到集合中,再将集合变成流的形式,
     * 这里面流的操作主要时在1.8的特性中
     * @param strings
     * @return
     */
    public static Stream<Character> getCharactor(String strings){
        char[] chars = strings.toCharArray();
        List<Character> list =new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }

        Stream<Character> stream = list.stream();
        return stream;


    }
    @Test
    public void method01(){
        List<String> list = Arrays.asList("abc", "def");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::getCharactor);
        streamStream.forEach((e) ->{e.forEach(System.out::println);});


    }
//    java1.8特性中流的操作,映射,其实这里面就是对里里面的元素一个一个的操作
//    在Java1.8的新特性中,映射操作,返回结果时流的形式,里面的类型就是单个操作的数据类型
//    过滤filter,去重;
//    映射,函数的一种通对象调用,静态类调用形式,类型调用方法,前提时有两个参数
//    函数式接口,在接口中添加defualt的形式,该接口就只能够有抽象方法,在Java中为了使用在使用方便,就自带了
//    接口 比如消费类型,提供类型,函数类型,
//    转化流的形式:
    /**
     * 有四种:一个就是直接通过集合方式调用stream
     * 一种就是通过数组调用流的形式
     */

    @Test
    public void method02(){
        Integer [] number={1,2,3,4,5,6};
        Stream<Integer> stream = Arrays.stream(number);
        Object[] objects =  stream.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

    }

    @Test
    public void method03(){
        Stream<Employee> stream = employees.stream();
        Object[] objects = stream.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

    }
    /**
     * 流形式:
     * 1.两种方法:
     * 1ma'p()
     * 2.flaMap()
     */
    /**
     * 总结:
     * 通过Java1.8转化成流之后是可以逆向转化成对象,或者自己需要的实体类,只是这里面的数据变成一个Object的形式!
     */


    /**
     * java 1.8新特性之排序
     * 排序有两种方式一种是自然排序,一种时自定义排序
     * 自然排序,是按照原来的是怎么样就怎么样输出
     * 第二种:就是自己传递排序的规则
     */
    @Test
    public void method04(){
        employees.stream().sorted((e,e2)->{
//           工资相同,按照名字排
            if(e.getSale()==e2.getSale()){
                return e.getName().compareTo(e.getName());
            }else{
                return e.getSale().compareTo(e.getSale());
            }


        });


    }


    @Test
    public  void method05(){
        Integer double1=1;
        Integer double2=2;
        int compare = Integer.compare(double1, double2);
        System.out.println(compare);
        /**
         * 思路:
         *  1.将集合转化成流
         *  2.调用集合里面的方法
         *  3.比较类型返回数字是一个是否为负数,是否为整数
         */


    }
    @Test
    public void method001(){
        Stream<Integer> integerStream = employees.stream().map(Employee::getSale);
        Object[] objects = integerStream.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    /**
     *
     * 需求:
     *  1.从集合中,手机对象中的名称,并放到集合容器中
     *
     *
     */
    @Test
    public void method002(){
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }
        employees.forEach(System.out::println);



    }

    /**
     * lambdab表达式中收集:
     * 1.收集成集合形式
     * 2.获取最大值
     * 3.获取总数量
     * 4.获取最小值
     */

    @Test
    public  void method003(){

//        获取总个数
        Long collect = employees.stream().map(Employee::getSale).collect(Collectors.counting());
        System.out.println(collect);
//        收集对象中名字,并放到List容器中:
        List<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toList());
        for (String s : collect1) {
            System.out.println(s);
        }
        System.out.println("收集最大值");
        Double collect2 = employees.stream().collect(Collectors.averagingInt(Employee::getSale));
        System.out.println(collect2);
        System.out.println("获取最大值");
        Optional<Employee> collect3 = employees.stream().collect(Collectors.maxBy((e, b) -> Integer.compare(e.getSale(), b.getSale())));
        System.out.println(collect3.get());

        System.out.println("获取集合中最小值");
        Optional<Employee> collect4 = employees.stream().collect(Collectors.minBy((e, b) -> Integer.compare(e.getSale(), b.getSale())));
        System.out.println(collect4.get());
//        如果直接是单个元素,就不需要
        Optional<Integer> collect5 = employees.stream().map(Employee::getSale).collect(Collectors.minBy(Integer::compareTo));
        System.out.println(collect5.get());
//        类似

    }
    @Test
    public void method005(){
        Map<Employee.Status, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);


    }


    /**
     * java 收集分组,多个分组,注意:
     *  1.如果分组中遇到没有分组标准,则出现异常
     *  2.
     */
    @Test
    public void method006(){
//        之前在写组织架构的时候,能够掌握着的话,自己的代码就会变成优雅许多
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining("/"));
        String[] split = collect.split("/");

        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(collect);

    }
    @Test
    public void method007(){
//        IntSummaryStatistics collect = employees.stream().map(Employee::getSale).collect(Collectors.summarizingInt(Integer::byteValue));
//        double average = collect.getAverage();
//        System.out.println(average);
//        long count = collect.getCount();
//        System.out.println(count);
        IntSummaryStatistics collect = employees.stream().collect(Collectors.summarizingInt(Employee::getSale));
        double average = collect.getAverage();
        System.out.println(average);
        Stream<Integer> integerStream = employees.stream().map(Employee::getSale);
//
        /**
         * 巧用Java1.8的新特性:
         * 1.从集合中获取到每一个内容,再变成数组形式
         * 2.将集合中内容,拼接起来,并且中间有内容进行划分,比如自己的组织架构,还有就是
         * 3.通过收集获取到集合中最大值
         * 4.通过收集获取到最小值
         * 5.排序,多种条件排序
         * 6.过滤
         * 7.分组
         * 8.排序
         * 9.获取最大值,最小值,平均值,
         * 10.终止操作
         */

        /**
         * 之前时间存在的问题:
         * 就是如果在多线程的情况下
         * 会出现线程安全的问题,处理的方式就是采用Localthread ,
         * 具体实现思路:
         *  1.创建时间格式转化对象simpleDateFormate();
         *  2.采用线程池,执行任务
         *  3.定义多线程执行的任务需要有返回数据,callable
         *  4.
         */

    }


}
