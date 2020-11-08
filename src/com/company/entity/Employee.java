package com.company.entity;

import java.io.Serializable;

public class Employee implements Serializable {


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String name;

    private String sex;

    private Integer sale;

    private Status  status;


    public Employee(String name, String sex, Integer sale) {
        this.name = name;
        this.sex = sex;
        this.sale = sale;
    }

    public Employee(String name, String sex, Integer sale, Status status) {
        this.name = name;
        this.sex = sex;
        this.sale = sale;
        this.status = status;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sale=" + sale +
                ", status=" + status +
                '}';
    }

    //    声明枚举:枚举是一个类
    public enum  Status{
        BUSY,
        VACATINO,
        FREE


    }
}
