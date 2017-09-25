package com.zhousz.pojo;

public class TbTeacher {
    private Integer teacherid;

    private String password;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
      return "TbTeacher [teacherid=" + teacherid + ", password=" + password + "]";
    }
    
    
}