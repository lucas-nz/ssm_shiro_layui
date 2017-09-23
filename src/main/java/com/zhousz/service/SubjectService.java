package com.zhousz.service;

import java.util.List;

import com.zhousz.dto.ResultSet;
import com.zhousz.entity.Subject;

public interface SubjectService {

  ResultSet<List<Subject>> getSubjectAll(int page, int limit);
  
  List<Subject> getSubjectList(int page, int limit);
}
