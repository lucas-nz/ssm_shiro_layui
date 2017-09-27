package com.zhousz.dto;

public class EsysResult<T> {
  
  private int total;
  
  private String msg;
  
  private T data;
  
  private String status;
  
  public EsysResult(int total, String status, String msg, T data) {
    this.data = data;
    this.msg = msg;
    this.total = total;
    this.status = status;
  }

  public EsysResult(String status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "EsysResult [total=" + total + ", msg=" + msg + ", data=" + data + ", status=" + status + "]";
  }
  
  
  
  
}
