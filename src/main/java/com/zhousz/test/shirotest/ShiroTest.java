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
    //1.��ȡSecurityManager����,�˴�ʹ��Ini�����ļ���ʼ��SecurityManager
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroIni/shiro-jdbc-realm.ini");
    
    //2.�õ�SecurityManagerʵ��,���󶨸�SecurityUtils
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
    
    //3.�õ�Subject�������û���/���������֤Token
    Subject subject = SecurityUtils.getSubject();
    
    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
    
    try {
      //4.��¼,�������֤
      subject.login(token);
    } catch (IncorrectCredentialsException  e) {
      System.out.println("�����ƾ֤!");
    } catch (LockedAccountException e) {
      System.out.println("�������˺�!");
    } catch (DisabledAccountException e) {
      System.out.println("���õ��˺�!");
    } catch (UnknownAccountException e) {
      System.out.println("������˺�!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("��¼ʧ�ܴ�������!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("���ڵ�ƾ֤!");
    }
    
    //�����û��Ѿ���¼
    Assert.assertEquals(true, subject.isAuthenticated()); 
    //5.�˳���¼
    subject.logout();
  
  }
  
  
  
  
  
  public void loginTest() {
    //1.ͨ��ʹ��Ini�����ļ���ʼ��SecurityManager 
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    //2.�õ�SecurityManagerʵ��,���󶨸�SecurityUtils
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
    //3.�õ�Subject�������û���/���������֤Token
    org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken("123", "12");
    try {
      //4.��¼,�������֤
      subject.login(token);
    } catch (IncorrectCredentialsException  e) {
      System.out.println("�����ƾ֤!");
    } catch (LockedAccountException e) {
      System.out.println("�������˺�!");
    } catch (DisabledAccountException e) {
      System.out.println("���õ��˺�!");
    } catch (UnknownAccountException e) {
      System.out.println("������˺�!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("��¼ʧ�ܴ�������!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("���ڵ�ƾ֤!");
    }
    
    Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼
    //�˳�
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
      System.out.println("�����ƾ֤!");
    } catch (LockedAccountException e) {
      System.out.println("�������˺�!");
    } catch (DisabledAccountException e) {
      System.out.println("���õ��˺�!");
    } catch (UnknownAccountException e) {
      System.out.println("������˺�!");
    } catch (ExcessiveAttemptsException e) {
      System.out.println("��¼ʧ�ܴ�������!");
    } catch (ExpiredCredentialsException e) {
      System.out.println("���ڵ�ƾ֤!");
    } catch (AuthenticationException e) {
      e.printStackTrace();
    }
    
    Assert.assertEquals(true, subject.isAuthenticated());
    subject.logout();
    
  }
  
  
  
  
  
  
  
}
