package com.zhousz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dto.ResultSet;
import com.zhousz.entity.Subject;
import com.zhousz.service.SubjectService;

@Controller
public class IndexController {
  
  @Autowired
  private SubjectService subjectService;
  
  @RequestMapping(value="/index")
  public String toIndex(){
    return "index";
  }
  
}