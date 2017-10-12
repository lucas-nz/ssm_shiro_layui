package com.zhousz.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhousz.pojo.SysUsers;

@Service
public class PasswordHelper {

  @Autowired
  private SysUserService sysUserService;
  
  private RandomNumberGenerator randomNumberGenerator =  new SecureRandomNumberGenerator();
  
  private String algorithmName = "md5";
  
  private int hashIterations = 2;

  public RandomNumberGenerator getRandomNumberGenerator() {
    return randomNumberGenerator;
  }

  public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public String getAlgorithmName() {
    return algorithmName;
  }

  public void setAlgorithmName(String algorithmName) {
    this.algorithmName = algorithmName;
  }

  public int getHashIterations() {
    return hashIterations;
  }

  public void setHashIterations(int hashIterations) {
    this.hashIterations = hashIterations;
  }
  
  
  public void newPassword(SysUsers user) {
    
    user.setSalt(randomNumberGenerator.nextBytes().toHex());
    
    String newPassword = new SimpleHash(
        algorithmName, 
        user.getPassword(), 
        user.getSalt(), 
        hashIterations).toHex();
    user.setPassword(newPassword);
  }
  
  public String getEntryPassword(String username, String password) {
    
    SysUsers user = sysUserService.getSysUserIfName(username);
    if (null == user) {
      return "";
    }
    String newPassword = new SimpleHash(
        algorithmName, 
        password,
        user.getSalt(), 
        hashIterations).toHex();
   return newPassword;
  }
  
  
}
