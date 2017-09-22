package com.zhousz.dto;

public class ResultSet<T> {
  
  private String code;
  
  private String msg;
  
  private int total;
  
  private T data;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
  
  public ResultSet() {
  }

  public ResultSet(String code, String msg, int total, T data) {
    this.code = code;
    this.msg = msg;
    this.total = total;
    this.data = data;
  }
  @Override
  public String toString() {
    return "ResultSet [code=" + code + ", msg=" + msg + ", total=" + total + ", data=" + data + "]";
  }
  
  
  
}
