package com.zhousz.dto;

public class imgResult {
  
  private String name;
  
  private String url;
  
  private int error;
  
  private String msg;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getError() {
    return error;
  }

  public void setError(int error) {
    this.error = error;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "imgResult [name=" + name + ", url=" + url + ", error=" + error + ", msg=" + msg + "]";
  }
  
  public imgResult(String name, String url, int error, String msg) {
    this.error = error;
    this.msg = msg;
    this.name = name;
    this.url = url;
  }
  
}
