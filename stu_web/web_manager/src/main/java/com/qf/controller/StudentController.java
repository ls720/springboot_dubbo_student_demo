package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/30
 */
@Controller
@RequestMapping("/stu")
public class StudentController {
    @Reference
    private IStudentService stuService;
    @RequestMapping("/list")
    public String list1(Model model){
        List<Student> list=stuService.list();
        model.addAttribute("stus",list);
        return "stuList";
    }
    //////
    ////
    @RequestMapping("/del")
    public java.lang.String delete(Integer id) {
        stuService.removeById(id);
        return "redirect:/stu/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("/add")
    public String add(Student student, ModelMap map) {
        System.out.println(student);
        stuService.save(student);
        return "redirect:/stu/list";
    }
    @RequestMapping("queryById")
    public String queryget(Integer id,ModelMap map){
        Student student=stuService.getById(id);
        map.put("stu",student);
        return "update";
    }

    @RequestMapping("update")
    public String update(Student student){
        stuService.updateById(student);
        return "redirect:/stu/list";
    }

}
