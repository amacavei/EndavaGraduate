package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by amacavei on 8/10/2015.
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUpdateDep(Department department) {

        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public void remove(Department department){
        sessionFactory.getCurrentSession().delete(department);
    }

    @Override
    public void find(Department department){
        sessionFactory.getCurrentSession().contains(department);
    }
}
