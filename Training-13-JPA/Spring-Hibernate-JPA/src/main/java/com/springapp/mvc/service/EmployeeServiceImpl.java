package com.springapp.mvc.service;

import com.springapp.mvc.dao.EmployeeDao;
import com.springapp.mvc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amacavei on 8/10/2015.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void createUpdate(Employee employee){
        employeeDao.createUpdate(employee);
    }

    @Override
    @Transactional
    public void remove(Employee employee){
        employeeDao.remove(employee);
    }

    @Override
    @Transactional
    public void find(Employee employee){
        employeeDao.find(employee);
    }
}
