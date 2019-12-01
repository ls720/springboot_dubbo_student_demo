package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/29
 */
public interface IClassesService {
    List<Classes> list();
    Classes queryById(int id);
}
