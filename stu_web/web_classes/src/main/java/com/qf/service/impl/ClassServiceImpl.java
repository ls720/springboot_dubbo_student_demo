package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassMapper;
import com.qf.entity.Classes;
import com.qf.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/29
 */
//阿里的包
@Service
public class ClassServiceImpl implements IClassesService {
   @Autowired
   private ClassMapper classMapper;

    @Override
    public List<Classes> list() {
        return classMapper.selectList(null);
    //null参数表示查所有shu
    }

    @Override
    public Classes queryById(int id) {
        return classMapper.selectById(id);
    }
}
