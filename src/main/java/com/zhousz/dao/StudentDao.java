package com.zhousz.dao;

import java.util.List;

import com.zhousz.entity.Student;

public interface StudentDao {
  
  int getCount();
  
  Student getStudentById(int studentId);
  
  List<Student> getStudentList();
}
