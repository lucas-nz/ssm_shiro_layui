/**
 * 
 */
package com.zhousz.service;

import org.springframework.web.multipart.MultipartFile;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.SysUserFile;

/**
 * @author ZhouSZ
 *
 */
public interface FileLoadService {

  EsysResult<SysUserFile> fileUpLoad(MultipartFile upload, String username);
  
  
}
