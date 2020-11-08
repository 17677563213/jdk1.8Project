package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

public class DateFormate01 {
//    创建时间转化格式
public static void main(String[] args) throws ExecutionException, InterruptedException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//多线程执行的逻辑
    Callable<Date> objectCallable = new Callable<Date>() {
        @Override
        public Date call() throws Exception {

            return sdf.parse("20201011");
        }
    };
    ArrayList< Future<Date> > dates = new ArrayList<>();

//    采用线程池创建线程:
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i <10 ; i++) {
        Future<Date> submit = executorService.submit(objectCallable);
        boolean add = dates.add(submit);
    }
    for (Future<Date> date : dates) {
        System.out.println(date.get());
    }

    /**
     * 思路总结:
     *  1.创建时间转化对象 simpleDateFormate(),在括号中填写自己定义的类型
     *  2.采用excutes.new ,采用多线程创建 自己需要的线程数目
     *  3.线程体 callable() 创建对象,匿名内部类,也就是接口中不需要实现类实现里面的接口,采用匿名内部类直接进行操作
     *  4.submit()来提交任务,括号填写自己线程体对象
     *  5.返回结果
     *  6.遍历获取时间
     */


}

}
