package com.zhousz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.entity.Subject;
import com.zhousz.service.SubjectService;

@Controller
public class IndexController {
  
  @Autowired
  private SubjectService subjectService;
  
  
  @RequestMapping(value="/index")
  public ModelAndView getSubjectAll() {
    ModelAndView mv = new ModelAndView();
    PageHelper.startPage(1, 10);
    List<Subject> list = subjectService.getSubjectAll();
    PageInfo<Subject> pageInfo = new PageInfo<Subject>(list);
    int total = (int)pageInfo.getTotal();
    mv.addObject("total", total);
    mv.addObject("subjectList", list);
    mv.setViewName("/index");
    return mv;
    
  }
    

  
}
