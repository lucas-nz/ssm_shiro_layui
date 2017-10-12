package com.zhousz.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.SysUserFile;
import com.zhousz.service.util.*;
import com.zhousz.service.FileLoadService;
import com.zhousz.service.SysUserFileService;


@Service
public class FileLoadServiceImpl implements FileLoadService{
 
  
  @Autowired
  private SysUserFileService sysUserFileService;
  
  @Value("${FTP_ADDRESS}")
  private String FTP_ADDRESS;
  
  @Value("${FTP_PORT}")
  private Integer FTP_PORT;
  
  @Value("${FTP_USERNAME}")
  private String FTP_USERNAME;
  
  @Value("${FTP_PASSWORD}")
  private String FTP_PASSWORD;
  
  @Value("${FTP_BASE_PATH}")
  private String FTP_BASE_PATH;
  
  @Value("${IMAGE_BASE_URL}")
  private String IMAGE_BASE_URL;

  /*      FTP_ADDRESS=192.168.231.130
  FTP_PORT=21
  FTP_USERNAME=ftpuser
  FTP_PASSWORD=ftpuser
  FTP_BASE_PATH=/home/ftpuser/www/images
  #\u56fe\u7247\u670d\u52a1\u5668\u7684\u76f8\u5173\u914d\u7f6e
  #\u56fe\u7247\u670d\u52a1\u5668\u7684\u57fa\u7840url
  IMAGE_BASE_URL=http://192.168.231.130/images
*/  
  
  public EsysResult<SysUserFile> fileUpLoad(MultipartFile upload, String username) {
    
    EsysResult<SysUserFile> result = new EsysResult<SysUserFile>();
    try {
      //取原始文件名
      String oldName = upload.getOriginalFilename();
      //生成一个新的文件名
      String newName = IDUtils.genImageName();
      newName = new DateTime().toString("yyyy-MM-dd") + "^" + newName;
      newName = newName + oldName.substring(oldName.lastIndexOf("."));
      //图片上传
      String imagePath = "/" + username + "/";
      System.out.println(imagePath + newName);
      boolean ret = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
          FTP_BASE_PATH, imagePath, newName, upload.getInputStream());
      //返回结果
      if(!ret){
        result.setMsg("上传失败!");
        result.setStatus("error");
        return result;
      }
      
      SysUserFile file = new SysUserFile();
      String url = IMAGE_BASE_URL + imagePath + newName;
      System.out.println("FTP_BASE_PATH" + FTP_BASE_PATH);
      System.out.println("IMAGE_BASE_URL" + IMAGE_BASE_URL);
      System.out.println("imagePath" + imagePath);
      System.out.println("url" + url);
      file.setFileName(oldName);
      file.setFileUrl(url);
      //file.setUserId((long) 1);
      int newFileRet = sysUserFileService.newSysUserFile(file);
      result.setData(file);
      result.setTotal(newFileRet);
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      result.setMsg("上传文件上传发生异常!");
      result.setStatus("error");
      return result;
    }
    
  }

  public EsysResult<SysUserFile> fileUpLoad() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
