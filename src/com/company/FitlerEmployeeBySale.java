package com.company;

import com.company.entity.Employee;

public class FitlerEmployeeBySale implements  FilterEmployee<Employee> {
    @Override
    public boolean test(Employee employee) {
        if(employee.getSale()>5000){
            return true;
        }else{

            return false;
        }
    }
}
