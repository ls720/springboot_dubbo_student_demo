package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/30
 */
public interface IStudentService {
    List<Student> list();

    void removeById(Integer id);

    void save(Student student);

    Student getById(Integer id);

    void updateById(Student student);
}
