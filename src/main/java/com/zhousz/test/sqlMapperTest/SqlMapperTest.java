package com.zhousz.test.sqlMapperTest;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhousz.mapper.SysUsersMapper;
import com.zhousz.mapper.TbStudentMapper;
import com.zhousz.pojo.SysUsers;
import com.zhousz.pojo.SysUsersExample;
import com.zhousz.pojo.SysUsersExample.Criteria;
import com.zhousz.pojo.TbStudent;
import com.zhousz.service.PasswordHelper;
import com.zhousz.test.BaseTest;

public class SqlMapperTest extends BaseTest {

  @Autowired
  private TbStudentMapper tbStudentMapper;
  
  @Autowired
  private SysUsersMapper sysUsersMapper;
  
  @Autowired
  private PasswordHelper passwordHelper;
  
  //@Test
  public void testShowStuList() {
    List<TbStudent> list = tbStudentMapper.selectByExample(null);
    System.out.println(list);
  }
  
  @Test
  public void testEncryPassword() {
    SysUsersExample example = new SysUsersExample();
    Criteria criteria = example.createCriteria();
    criteria.andUsernameEqualTo("admin");
    List<SysUsers> users = sysUsersMapper.selectByExample(example);
    if (users.size() > 0 && null != users) {
      SysUsers user = users.get(0);
      user.setPassword("admin");
      ///user.setSalt("");
      passwordHelper.newPassword(user);
      System.out.println("test:" + user);
    }
    else{
      System.out.println("no result");
    }
  }
  
  
  
  
  
  
  
}
