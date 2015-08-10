package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Project;

/**
 * Created by amacavei on 8/10/2015.
 */
public interface ProjectDao {

    void find(Project project);
    void remove(Project project);
    void createUpdate(Project project);
}
