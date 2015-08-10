package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by amacavei on 8/10/2015.
 */

@Entity(name = "prj")
public class Project {

    @Id
    @Column(name = "PJ_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PJ_NAME")
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public int getProjecId() {
        return id;
    }

    public String getProjectName() {
        return name;
    }

    public void setProjectId(int id) {
        this.id = id;
    }

    public void setProjectName(String name) {
        this.name = name;
    }
}
