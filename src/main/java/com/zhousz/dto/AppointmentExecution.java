package com.zhousz.dto;

import com.zhousz.entity.Appointment;
import com.zhousz.enums.AppointmentStateEnum;

/**
 * @description 封装预约执行后的结果
 * @author ZhouSZ
 *
 */
public class AppointmentExecution {
  
  //图书Id
  private long bookId;
  
  //预约结果状态
  private int state;
  
  //状态标识
  private String stateInfo;
  
  //预约成功对象
  private Appointment appointment;
  
  public AppointmentExecution() {
  }
  
  //预约失败构造器
  public AppointmentExecution(long bookId, AppointmentStateEnum stateEnum) {
    this.bookId = bookId;
    this.state = stateEnum.getState();
    this.stateInfo = stateEnum.getStateInfo();
  }

  //预约成功构造器
  public AppointmentExecution(long bookId, AppointmentStateEnum stateEnum, Appointment appointment) {
    this.bookId = bookId;
    this.state = stateEnum.getState();
    this.stateInfo = stateEnum.getStateInfo();
    this.appointment = appointment;
  }

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getStateInfo() {
    return stateInfo;
  }

  public void setStateInfo(String stateInfo) {
    this.stateInfo = stateInfo;
  }

  public Appointment getAppointment() {
    return appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  @Override
  public String toString() {
    return "AppointmentExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" + stateInfo + ", appointment="
        + appointment + "]";
  }
 
  
}
