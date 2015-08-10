package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by amacavei on 8/10/2015.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUpdate(Project project) {

        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    @Override
    public void remove(Project project){
        sessionFactory.getCurrentSession().delete(project);
    }

    @Override
    public void find(Project project){
        sessionFactory.getCurrentSession().contains(project);
    }

}
