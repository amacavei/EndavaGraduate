package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Employee;

/**
 * Created by amacavei on 8/10/2015.
 */
public interface EmployeeDao {

    void find(Employee employee);
    void remove(Employee employee);
    void createUpdate(Employee employee);
}
