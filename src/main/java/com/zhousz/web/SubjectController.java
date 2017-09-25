package com.zhousz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhousz.pojo.TbSubject;
import com.zhousz.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
  
  @Autowired
  private SubjectService subjectService;
  
  
  @RequestMapping("/list")
  @ResponseBody
  public List<TbSubject> geTbSubjects(){
    return subjectService.geTbSubjects();
  }
  
  
}
