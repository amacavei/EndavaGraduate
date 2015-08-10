package com.springapp.mvc.service;

import com.springapp.mvc.dao.ProjectDao;
import com.springapp.mvc.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amacavei on 8/10/2015.
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    @Transactional
    public void createUpdate(Project project){
        projectDao.createUpdate(project);
    }

    @Override
    @Transactional
    public void remove(Project project){
        projectDao.remove(project);
    }

    @Override
    @Transactional
    public void find(Project project){
        projectDao.find(project);
    }

}
