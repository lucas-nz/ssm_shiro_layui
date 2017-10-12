package com.zhousz.service;

import java.util.List;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.TbSubject;

public interface SubjectService {
  
  EsysResult<List<TbSubject>> geTbSubjects(int page, int limit);

}
