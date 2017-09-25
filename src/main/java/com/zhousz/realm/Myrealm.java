package com.zhousz.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class Myrealm implements Realm {
  
  public String getName() {
    return "Myrealm";
  }   
  
  public boolean supports(AuthenticationToken token) {
    return token instanceof UsernamePasswordToken; //��֧��UsernamePasswordToken���͵�Token
  }
  
  public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    String username = (String)token.getPrincipal(); //�õ��û���
    String password = new String((char[])token.getCredentials()); //�õ�����
    
    if(!"zhang".equals(username)){
      throw new UnknownAccountException();
    }
    if (!"123".equals(password)) {
      throw new IncorrectCredentialsException();
    }
    return new SimpleAuthenticationInfo(username, password, getName());
  }
}