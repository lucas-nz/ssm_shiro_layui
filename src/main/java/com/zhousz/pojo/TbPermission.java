package com.zhousz.pojo;

public class TbPermission {
    private Integer permissionid;

    private String permissionname;

    private Integer roleid;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
      return "TbPermission [permissionid=" + permissionid + ", permissionname=" + permissionname + ", roleid=" + roleid
          + "]";
    }
}