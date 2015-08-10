package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Department;

/**
 * Created by amacavei on 8/10/2015.
 */
public interface DepartmentDao {

    void find(Department department);
    void remove(Department department);
    void createUpdateDep(Department department);
}
