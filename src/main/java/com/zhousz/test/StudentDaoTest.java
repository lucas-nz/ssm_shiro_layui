package com.zhousz.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dao.StudentDao;
import com.zhousz.dto.ResultSet;
import com.zhousz.entity.Student;

public class StudentDaoTest extends BaseTest {
  
  @Autowired
  private StudentDao studentDao;

  
  @Test
  public void testGetStudentList()throws Exception{
    
    PageHelper.startPage(1, 10);
    List<Student> list = studentDao.getStudentList();
    PageInfo<Student> pageInfo = new PageInfo<Student>(list);
    String code = "0";
    String msg = "success";
    int total = (int)pageInfo.getTotal();
    int pages = pageInfo.getPages();
   System.out.println(list);
    
    
  }
}
