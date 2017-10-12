package com.zhousz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhousz.dto.EsysResult;
import com.zhousz.mapper.TbSubjectMapper;
import com.zhousz.pojo.TbSubject;
import com.zhousz.service.SubjectService;


@Service
public class SubjectServiceImpl implements SubjectService{

  @Autowired
  private TbSubjectMapper subjectMapper;
  
  public EsysResult<List<TbSubject>> geTbSubjects(int page, int limit) {
    PageHelper.startPage(page, limit);
    List<TbSubject> list = subjectMapper.selectByExample(null);
    PageInfo<TbSubject> pageInfo = new PageInfo<TbSubject>(list);
    return new EsysResult<List<TbSubject>>((int)pageInfo.getTotal(),"success", "success", list);
  }
}
