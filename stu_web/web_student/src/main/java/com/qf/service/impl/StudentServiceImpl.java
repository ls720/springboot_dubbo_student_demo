package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.IStudentMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/30
 */
@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {
   @Autowired
   private IStudentMapper stuMapper;
   @Reference
   private IClassesService classesService;
    @Override
    public List<Student> list() {
        List<Student> stuList=stuMapper.selectList(null);
        System.out.println(stuList);
        for(Student stu:stuList){
            Integer cid=stu.getCid();
            Classes classes=classesService.queryById(cid);

            stu.setCls(classes);

        }
        return stuList;
    }

    @Override
    public void removeById(Integer id) {
        stuMapper.deleteById(id);
    }

    @Override
    public void save(Student student) {
            stuMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        Student student=stuMapper.selectById(id);

        return student;
                }

@Override
public void updateById(Student student) {
        stuMapper.updateById(student);
        }
        }
