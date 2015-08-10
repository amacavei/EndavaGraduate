package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by amacavei on 8/10/2015.
 */
@Entity(name = "dep")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "DEP_ID")
    private int id;

    @Column(name = "DEP_NAME")
    private String name;

    @OneToMany(targetEntity = Employee.class , mappedBy = "department")
    private Collection<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    public int getDepartmentId(){
        return id;
    }

    public String getDepartmentName(){
        return name;
    }

    public void setDepartmentId(int id){
        this.id = id;
    }

    public void setDepartmentName(String name){
        this.name = name;
    }
}
