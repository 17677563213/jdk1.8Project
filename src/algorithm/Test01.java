package algorithm;

public class Test01 {
    public static void main(String[] args) {
        Comparable comparaResult = getComparaResult(new Student("wxy", 22), new Student("yuexia", 23));
        System.out.println(comparaResult);

    }

    public static  Comparable getComparaResult(Comparable cp1,Comparable cp2){
        int i = cp1.compareTo(cp2);

        if(i>=0){
            return cp1;
        }else{
            return cp2;
        }


    }
//    静态方法中不能够调用对象方法,所谓的对象方法就是需要创建对象之后才能够调用的方法,静态方法就是添加static
//    关键进行修饰的方法,对象方法之间可以进行调用,静态方法之间可以进行调用
//    总结:
    /**
     */
//    计算机网络,操作系统,数据结构与算法
//自己现在研究的就是算法,Java的高并发场景该如何进行处理,因为大公司面试就是考这些内容

}
