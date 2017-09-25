package com.zhousz.test.sqlMapperTest;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhousz.mapper.TbStudentMapper;
import com.zhousz.pojo.TbStudent;
import com.zhousz.test.BaseTest;

public class SqlMapperTest extends BaseTest {

  @Autowired
  private TbStudentMapper tbStudentMapper;
  
  @Test
  public void testShowStuList() {
    List<TbStudent> list = tbStudentMapper.selectByExample(null);
    System.out.println(list);
  }
  
}
