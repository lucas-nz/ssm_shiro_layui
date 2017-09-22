package com.zhousz.entity;

public class Student {
  
  private int studentId;
  

  private String password;
  
  private String studentName;
  
  private int result;
  
  private String sclass;

  public String getPassword() {
    return password;
  }

  public int getStudentId() {
    return studentId;
  }
  
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public String getSclass() {
    return sclass;
  }

  public void setSclass(String sclass) {
    this.sclass = sclass;
  }

  @Override
  public String toString() {
    return "Student [studentId=" + studentId + ", password=" + password + ", studentName=" + studentName + ", result="
        + result + ", sclass=" + sclass + "]";
  }


  
}
