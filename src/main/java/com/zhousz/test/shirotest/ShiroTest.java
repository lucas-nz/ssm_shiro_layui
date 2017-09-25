package com.zhousz.test.shirotest;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhousz.mapper.TbStudentMapper;
import com.zhousz.pojo.TbStudent;
import com.zhousz.test.BaseTest;

import junit.framework.Assert;

public class ShiroTest extends BaseTest {
  
  
  @Autowired
  private TbStudentMapper tbStudentMapper; 
  
  
  @Test
  public void testJDBCRealm() {
    
    TbStudent student = tbStudentMapper.selectByPrimaryKey(10001);
    System.out.println(student);
    student.getPassword();
    //1.获取SecurityManager工厂,此处使用Ini配置文件初始化SecurityManager
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroIni/shiro-jdbc-realm.ini");
    
    //2.得到SecurityManager实例,并绑定给SecurityUtils
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
    
    //3.得到Subject及创建用户名/密码身份验证Token
    Subject subject = SecurityUtils.getSubject();
    
    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
    
    try {
      //4.登录,即身份验证
      subject.login(token);
    } catch (IncorrectCredentialsException  e) {
      System.out.println("错误的凭证!");
    } catch (LockedAccountException e) {
      System.out.println("锁定的账号!");
    } catch (DisabledAccountException e) {
      System.out.println("禁用的账号!");
    } catch (UnknownAccountException e) {
      System.out.println("错误的账号!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("登录失败次数过多!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("过期的凭证!");
    }
    
    //断言用户已经登录
    Assert.assertEquals(true, subject.isAuthenticated()); 
    //5.退出登录
    subject.logout();
  
  }
  
  
  
  
  
  public void loginTest() {
    //1.通过使用Ini配置文件初始化SecurityManager 
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    //2.得到SecurityManager实例,并绑定给SecurityUtils
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
    //3.得到Subject及创建用户名/密码身份验证Token
    org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken("123", "12");
    try {
      //4.登录,即身份验证
      subject.login(token);
    } catch (IncorrectCredentialsException  e) {
      System.out.println("错误的凭证!");
    } catch (LockedAccountException e) {
      System.out.println("锁定的账号!");
    } catch (DisabledAccountException e) {
      System.out.println("禁用的账号!");
    } catch (UnknownAccountException e) {
      System.out.println("错误的账号!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("登录失败次数过多!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("过期的凭证!");
    }
    
    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
    //退出
    subject.logout();
    
  }
  
  public void testCustomReal() {
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroIni/shiro-realm.ini");
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken("123", "123");
    try {
      subject.login(token);
    }catch (IncorrectCredentialsException  e) {
      System.out.println("错误的凭证!");
    } catch (LockedAccountException e) {
      System.out.println("锁定的账号!");
    } catch (DisabledAccountException e) {
      System.out.println("禁用的账号!");
    } catch (UnknownAccountException e) {
      System.out.println("错误的账号!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("登录失败次数过多!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("过期的凭证!");
    } catch (AuthenticationException e) {
      e.printStackTrace();
    }
    
    Assert.assertEquals(true, subject.isAuthenticated());
    subject.logout();
    
  }
  
  
  
  
  
  
  
}
