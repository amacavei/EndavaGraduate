package com.springapp.mvc.service;

import com.springapp.mvc.dao.DepartmentDao;
import com.springapp.mvc.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amacavei on 8/10/2015.
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public void createUpdateDep(Department department){
        departmentDao.createUpdateDep(department);
    }

    @Override
    @Transactional
    public void remove(Department department){
        departmentDao.remove(department);
    }

    @Override
    @Transactional
    public void find(Department department){
        departmentDao.find(department);
    }
}
