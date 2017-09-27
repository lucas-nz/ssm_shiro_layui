package com.zhousz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhousz.mapper.SysUsersMapper;
import com.zhousz.pojo.SysUsers;
import com.zhousz.pojo.SysUsersExample;
import com.zhousz.pojo.SysUsersExample.Criteria;
import com.zhousz.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
  
  @Autowired
  private SysUsersMapper sysUsersMapper;
  
  public SysUsers getSysUserIfName(String username) {
    SysUsersExample example = new SysUsersExample();
    Criteria criteria = example.createCriteria();
    criteria.andUsernameEqualTo(username);
    List<SysUsers> list = sysUsersMapper.selectByExample(example);
    if (list != null && list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

}
