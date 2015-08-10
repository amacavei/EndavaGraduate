package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by amacavei on 8/9/2015.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Student student) {

        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }
}
