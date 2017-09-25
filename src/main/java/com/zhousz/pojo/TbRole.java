package com.zhousz.pojo;

public class TbRole {
    private Integer roleid;

    private String rolename;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    @Override
    public String toString() {
      return "TbRole [roleid=" + roleid + ", rolename=" + rolename + "]";
    }
    
    
}