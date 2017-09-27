package com.zhousz.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhousz.pojo.SysUsers;
import com.zhousz.service.SysUserService;

public class Myrealm extends AuthorizingRealm{
  
  @Autowired
  private SysUserService sysUserService;

  //设置realm的名称
  @Override
  public void setName(String name) {
    super.setName("Myrealm");
  }
  
  //用于认证 authentication 验证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    //token是用户输入的
    //第一步: 从token中取出身份信息
    String  username = (String)token.getPrincipal();
    
    //根据用户输入的username从数据库中查找
    SysUsers sysuser = sysUserService.getSysUserIfName(username);
    
    if (null == sysuser) {
      throw new UnknownAccountException(); // 没找到账号
    }
    if (Boolean.TRUE.equals(sysuser.getLocked())) {
      throw new LockedAccountException(); // 账号被锁定
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysuser.getUsername(),
        sysuser.getPassword(),
        this.getName());
    //如果查询到,返回认证信息AuthenticationInfo
    
    //将activeUser设置到simpleAuthenticationInfo
    
    return info;
  }
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
  }


}