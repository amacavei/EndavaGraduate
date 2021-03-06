package com.springapp.mvc.service;

import com.springapp.mvc.dao.StudentDao;
import com.springapp.mvc.dao.StudentDaoImpl;
import com.springapp.mvc.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amacavei on 8/9/2015.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void insert(Student student) {
        studentDao.insert(student);

    }
}
