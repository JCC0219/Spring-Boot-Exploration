package com.luv2code.springboot.demo.mycoolapp.dao;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findyById(int theId);
    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
