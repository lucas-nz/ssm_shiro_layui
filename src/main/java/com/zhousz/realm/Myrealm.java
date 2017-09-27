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

  //����realm������
  @Override
  public void setName(String name) {
    super.setName("Myrealm");
  }
  
  //������֤ authentication ��֤
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    //token���û������
    //��һ��: ��token��ȡ�������Ϣ
    String  username = (String)token.getPrincipal();
    
    //�����û������username�����ݿ��в���
    SysUsers sysuser = sysUserService.getSysUserIfName(username);
    
    if (null == sysuser) {
      throw new UnknownAccountException(); // û�ҵ��˺�
    }
    if (Boolean.TRUE.equals(sysuser.getLocked())) {
      throw new LockedAccountException(); // �˺ű�����
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysuser.getUsername(),
        sysuser.getPassword(),
        this.getName());
    //�����ѯ��,������֤��ϢAuthenticationInfo
    
    //��activeUser���õ�simpleAuthenticationInfo
    
    return info;
  }
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
  }


}