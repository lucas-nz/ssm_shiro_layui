package com.zhousz.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dao.SubjectDao;
import com.zhousz.entity.Subject;

public class SubjectDaoTest extends BaseTest {

  @Autowired
  private SubjectDao subjectDao;
  
  @Test
  public void testGetSubjectAll()throws Exception{
    PageHelper.startPage(1, 10); 
    List<Subject> list = subjectDao.getSubjectAll();
    PageInfo<Subject> pageInfo = new PageInfo<Subject>(list);
   
  }
  
}
