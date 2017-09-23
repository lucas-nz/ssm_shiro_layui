package com.zhousz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhousz.dto.ResultSet;
import com.zhousz.entity.Subject;
import com.zhousz.service.SubjectService;


@Controller
@RequestMapping(value="/subject")
public class SubjectController {

  
  @Autowired
  private SubjectService subjectService;
  
  
  @RequestMapping(value="/list1", method=RequestMethod.POST)
  @ResponseBody
  public ResultSet<List<Subject>> getSubjectAll(@RequestParam int page, @RequestParam int limit) {
    ResultSet<List<Subject>> resultSet = subjectService.getSubjectAll(page, limit);
    return resultSet ;
  }



  @RequestMapping(value="/list", method=RequestMethod.GET)
  @ResponseBody
  public List<Subject> getSubjectList(@RequestParam int page, @RequestParam int limit) {
    System.out.println("page=" + page + ";limit=" + limit);
    return subjectService.getSubjectList(page, limit);
  }



}
