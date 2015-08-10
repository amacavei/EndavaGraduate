package com.springapp.mvc.domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by amacavei on 8/10/2015.
 */
@Entity(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private int id;

    @Column(name = "EMP_NAME")
    private String name;

    @Column(name = "EMP_SALARY")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "DEP_ID")
    private Department department;

    @Column(name = "EMP_STREET")
    private String street;

    @Column(name = "EMP_CITY")
    private String city;

    @Column(name = "EMP_STATE")
    private String state;

    @Column(name = "EMP_ZIP")
    private long zipCode;

    @Column(name = "EMP_DOB")
    private Date birthday;

    @ManyToMany
    @JoinTable(name = "EMP_PJ", joinColumns = @JoinColumn(name = "EMP_ID"),inverseJoinColumns = @JoinColumn(name = "PJ_ID"))
    private Collection<Project> projects;

    public int getEmployeeId() {
        return id;
    }

    public String getEmployeeName() {
        return name;
    }

    public int getEmployeeSalary() {
        return salary;
    }

    public Department getEmployeeDepartment() {
        return department;
    }

    public String getEmployeeStreet() {
        return street;
    }

    public String getEmployeeCity() {
        return city;
    }

    public String getEMployeeState() {
        return state;
    }

    public long getEmployeeZipCode() {
        return zipCode;
    }

    public Date getEmployeeBirthday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.format(birthday);
        return birthday;
    }

    public Collection<Project> getEmployeeProjects() {
        return projects;
    }

    public void setEmployeeId(int id) {
        this.id = id;
    }

    public void setEmployeeName(String name) {
        this.name = name;
    }

    public void setEmployeeSalary(int salary) {
        this.salary = salary;
    }

    public void setEmployeeDepartment(Department department) {
        this.department = department;
    }

    public void setEmployeeStreet(String street) {
        this.street = street;
    }

    public void setEmployeeCity(String city) {
        this.city = city;
    }

    public void setEmployeeState(String state) {
        this.state = state;
    }

    public void setEmployeeZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public void setEmployeeBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmployeeProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
