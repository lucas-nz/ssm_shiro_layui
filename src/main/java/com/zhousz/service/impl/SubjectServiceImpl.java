package com.zhousz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhousz.dao.SubjectDao;
import com.zhousz.entity.Subject;
import com.zhousz.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectDao subjectDao;
  
  public List<Subject> getSubjectAll() {
    List<Subject> list = subjectDao.getSubjectAll();
    return list;
  }
}
