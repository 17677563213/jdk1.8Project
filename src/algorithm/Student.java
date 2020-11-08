package algorithm;

public class Student implements  Comparable<Student> {
    /**
     * 思路:
     *  1.创建实体类
     *  2.实体类实现comparable的接口
     *  3.定义比较的规则
     *  4.顶一个方法
     * @param o
     * @return
     */

    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public Student() {
    }
//    定义比较的规则:
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }


}
