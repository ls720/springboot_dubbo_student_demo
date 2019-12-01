package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.service.IClassesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author bllt
 * @Date 2019/11/29
 */
@Controller
@RequestMapping("/cls")
public class ClassController {
/*@Autowired下面导阿里的包*/
@Reference
private IClassesService classesService;
    @RequestMapping("/list")
    public String list(ModelMap map){
        List<Classes> list=classesService.list();
        map.put("clas",list);
        return "classList";
    }
}
