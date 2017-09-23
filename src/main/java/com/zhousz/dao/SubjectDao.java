package com.zhousz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhousz.entity.Subject;

public interface SubjectDao {
  
  List<Subject> getSubjectAll(@Param("start") int start,@Param("limit") int limit);
  
  int getCount();
}
