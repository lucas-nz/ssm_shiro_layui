package com.zhousz.dto;

public class Result<T> {
  
  private boolean success; //�Ƿ�ɹ���־
  
  private T data; //�ɹ�ʱ���ص�����
  
  private String error; //������Ϣ
  
  public Result() {
  }

  public Result(boolean success, T data) {
    this.data = data;
    this.success = success;
  }

  public Result(boolean success, String error) {
    this.success = success;
    this.error = error;
  }

  
  
  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "Result [success=" + success + ", data=" + data + ", error=" + error + "]";
  }
  
  

}
