package com.zhousz.service;

import java.util.List;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.SysUserFile;

public interface SysUserFileService {
  
  int newSysUserFile(SysUserFile file);
  
  EsysResult< List<SysUserFile>> getSysUserFile(int page, int limit);
  
}
