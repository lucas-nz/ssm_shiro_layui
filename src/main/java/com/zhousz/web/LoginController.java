package com.zhousz.web;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhousz.dto.EsysResult;
import com.zhousz.pojo.SysUsers;
import com.zhousz.service.PasswordHelper;
import com.zhousz.service.SysUserService;

@Controller
public class LoginController {
  
  @Autowired
  private SysUserService sysUserService;
  
  @Autowired
  private PasswordHelper passwordHelper;
  
  @RequestMapping(value = "/toLogin")
  public String toLogin(){
    return "login";
  }
  
  @RequestMapping("/login")
  @ResponseBody
  public EsysResult<String> login(SysUsers user, HttpSession session){
    Subject currUser = SecurityUtils.getSubject();
    String status = null;
    String msg = null;
    
    if (!currUser.isAuthenticated()) {
      String password = passwordHelper.getEntryPassword(user.getUsername(), user.getPassword());
      UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),password);
      try {
        
        currUser.login(token);
        status = "success";
        msg = "success";
      }catch (UnknownAccountException e){
        status = "error";
        msg = "�����ڵ��˺�!";
        System.out.println("�����ڵ��˺�!");
      }
      catch (IncorrectCredentialsException  e) {
        status = "error";
        msg = "�����ƾ֤!";
        System.out.println("�����ƾ֤!");
      } catch (LockedAccountException e) {
        status = "error";
        msg = "�������˺�!";
        System.out.println("�������˺�!");
      } catch (DisabledAccountException e) {
        status = "error";
        msg = "���õ��˺�!";
        System.out.println("���õ��˺�!");
      } catch (AuthenticationException e) {
        status = "error";
        msg = "������˺�!";
      }
    }
    EsysResult<String> result = new EsysResult<String>(status, msg);
    System.out.println(result);
    return result;
    
  }
  
  
  @RequestMapping("/logout")
  public String logout(){
    Subject currUser = SecurityUtils.getSubject();
    currUser.logout();
    return "/index";
  }
  
  
  
  
}
