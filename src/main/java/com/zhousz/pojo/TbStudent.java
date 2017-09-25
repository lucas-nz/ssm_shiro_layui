package com.zhousz.pojo;

public class TbStudent {
    private Integer studentid;

    private Integer roleid;

    private String password;

    private String studentname;

    private Integer result;

    private String sclass;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    @Override
    public String toString() {
      return "TbStudent [studentid=" + studentid + ", roleid=" + roleid + ", password=" + password + ", studentname="
          + studentname + ", result=" + result + ", sclass=" + sclass + "]";
    }
    
    
    
}