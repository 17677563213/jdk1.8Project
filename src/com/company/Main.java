package com.company;
import com.company.entity.Employee;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    @Test
    public void test01(){
        /**
         */
        List<Employee> employees = Arrays.asList(new Employee("小肥羊", "男", 2000),
                new Employee("旺财", "男", 6000),
                new Employee("二当家", "男", 5000),
                new Employee("小灰灰", "女", 4000),
                new Employee("海虹", "女", 2200)
        );
        Stream<Employee> employeeStream =
                employees
                        .stream()
                        .filter((e) -> (e.getSale() > 3000)).limit(3);

        employeeStream.forEach(System.out::println);
        System.out.println("====================");
        employees.stream().filter((e)->(e.getSale()>4000)).map(Employee::getName).forEach(System.out::println);
//        返回结果就是一个字符串形式
        Stream<String> stringStream = employees.stream().map(Employee::getName);

        System.out.println("===============");
        List<Employee> employees1 = filterEmployee(employees, new FitlerEmployeeBySale());
        for (Employee employee : employees1) {
            System.out.println(employee);
        }
        System.out.println("---------------------");



    }


    public  List<Employee> filterEmployee (List<Employee> employeeList ,FilterEmployee<Employee> filterEmployee){
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (filterEmployee.test(employee)){
                employees.add(employee);
            }
        }
        return employees;
    }


    @Test
    public void test04(){
//        函数式接口:
        OperationNumber oN=() -> System.out.println("方法测试!");
        oN.test01();
    }

    @Test
    public void test05(){
        handlerNumber(200L, 400L,(x,y) ->{
            return x+y;
        } );


    }

    public void handlerNumber(Long l1,Long l2,MyFunction<Long,Long> myFunction){
        System.out.println(myFunction.numberHandler(l1, l2));
    }
    /**
     * 函数式接口:消费类型
     *      特点:接收参数,没有返回结果
     *      函数接口:Consumer
     *      函数中方法:accept()
     */
    public void getNumber(String str, Consumer<String> consumer){
        consumer.accept(str);

    }
    @Test
    public void consumerTest(){
        getNumber("尚硅谷", (string) ->{
            int length = string.length();
            System.out.println("consumer消费类型函数式接口"+length);
        });
    }


    /**
     * 提供类型函数式接口:Supplier
     * 函数中方法:get()
     * 函数方法特点:没有参数,有返回结果
     *
     *
     *
     */
    public List<Integer> getRondowNumber(Integer num, Supplier<Integer> supplier){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            Integer integer = supplier.get();
            integers.add(integer);
        }
        return integers;

    }
    @Test
    public void test06(){
        List<Integer> rondowNumber = getRondowNumber(10, () ->{
            System.out.println( (int) (Math.random() * 100));
            System.out.println("======");
            return  (int) Math.random() * 100;
        });
        for (Integer integer : rondowNumber) {
            System.out.println(integer);
        }


    }


    /**
     * 函数式接口:有两个泛型,一个参数,一个返回类型
     * 函数式接口名称:Function;
     * 接口中方法:
     */
    public  void getString (List<String> strList, Function<String ,String> function){
        ArrayList<String> strings = new ArrayList<>();
        for (String string : strList) {
            String apply = function.apply(string);
            System.out.println("符合要求的数据"+apply);
        }



    }
    @Test
    public void test07() {
        List<String> strings = Arrays.asList("wxy", "小肥羊", "村花", "旺财");
        getString(strings, (e) -> {
                    if (e.length() > 1) return e;
                    else return null;

                }

        );
    }


    /**
     * lambda表达式 方法调用
     *  1.对象调用
     *  2.类调用
     *  3.数据类型调用
     *  他们共同点:中间采用两个冒号连接,参数列表与返回的数据需要与接口中抽象方法保持一致
     *
     */
    @Test
    public void test08(){
        Employee employee = new Employee();
         Supplier<String> name=employee::getName;
        System.out.println(name.get());
        System.out.println("=====================");

        BiPredicate<String ,String> result=String::equals;
        System.out.println("判断结果!");

        boolean test = result.test("wxy", "yeuxia");
        System.out.println(test);
    }
    /**
     */








}
