package com.zhousz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dto.EsysResult;
import com.zhousz.mapper.SysUserFileMapper;
import com.zhousz.pojo.SysUserFile;
import com.zhousz.pojo.SysUserFileExample;
import com.zhousz.pojo.SysUsersExample;
import com.zhousz.pojo.SysUsersExample.Criteria;
import com.zhousz.service.SysUserFileService;

@Service
public class SysUserFileServiceImpl implements SysUserFileService{
  
  @Autowired
  private SysUserFileMapper sysUserFileMapper;
  
  public int newSysUserFile(SysUserFile file) {
    return sysUserFileMapper.insertSelective(file);
  }
  
  public EsysResult<List<SysUserFile>> getSysUserFile(int page, int limit) {
    PageHelper.startPage(page, limit);
    SysUserFileExample example = new SysUserFileExample();
    example.setOrderByClause("file_id DESC");
    List<SysUserFile> list = sysUserFileMapper.selectByExample(example);
    PageInfo<SysUserFile> pageInfo = new PageInfo<SysUserFile>(list);
    int total = (int)pageInfo.getTotal();
    return new EsysResult<List<SysUserFile>>(total, "success", "success", list);
  }
  
}
