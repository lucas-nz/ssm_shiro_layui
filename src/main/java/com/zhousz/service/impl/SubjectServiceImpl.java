package com.zhousz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dao.CommonDao;
import com.zhousz.dao.SubjectDao;
import com.zhousz.dto.ResultSet;
import com.zhousz.entity.Subject;
import com.zhousz.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectDao subjectDao;
  
  public ResultSet<List<Subject>> getSubjectAll(int page, int limit) {
    int start = page * limit;
    List<Subject> list = subjectDao.getSubjectAll(start, limit);
    int total = subjectDao.getCount(); 
    System.out.println("total=" + total + ";count=" + list.size());
    ResultSet<List<Subject>> resultSet =  new ResultSet<List<Subject>>("0", "success", total, list);
    return resultSet;
  }
  
  public List<Subject> getSubjectList(int page, int limit) {
    int start = page * limit;
    return subjectDao.getSubjectAll(start, limit);
  }
}
