package com.zhousz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.SysUserFile;
import com.zhousz.service.FileLoadService;
import com.zhousz.service.SysUserFileService;


@Controller
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private FileLoadService fileLoadService;
  
  @Autowired
  private SysUserFileService sysUserFileService;
  
  @RequestMapping("/album")
  public String toUserAlbum(){
    return "ualbum";
  }


  @RequestMapping("/album/upload")
  @ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
  @ResponseBody
  public EsysResult<SysUserFile> albumUpload(@RequestParam(value="file")MultipartFile multipartFile, @RequestParam("username")String username){
      EsysResult<SysUserFile> result = fileLoadService.fileUpLoad(multipartFile, username);
      return result;
  }
  
  @RequestMapping("/album/list")
  @ResponseBody
  public EsysResult<List<SysUserFile>> albumList(@RequestParam int page, @RequestParam int limit){
    return sysUserFileService.getSysUserFile(page, limit);
  }


}
