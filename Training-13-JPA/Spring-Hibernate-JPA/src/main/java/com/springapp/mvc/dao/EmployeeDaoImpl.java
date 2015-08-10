package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by amacavei on 8/10/2015.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUpdate(Employee employee) {

        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public void remove(Employee employee){
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void find(Employee employee){
        sessionFactory.getCurrentSession().contains(employee);
    }
}
