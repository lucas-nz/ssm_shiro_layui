package com.zhousz.dto;

import com.zhousz.entity.Appointment;
import com.zhousz.enums.AppointmentStateEnum;

/**
 * @description ��װԤԼִ�к�Ľ��
 * @author ZhouSZ
 *
 */
public class AppointmentExecution {
  
  //ͼ��Id
  private long bookId;
  
  //ԤԼ���״̬
  private int state;
  
  //״̬��ʶ
  private String stateInfo;
  
  //ԤԼ�ɹ�����
  private Appointment appointment;
  
  public AppointmentExecution() {
  }
  
  //ԤԼʧ�ܹ�����
  public AppointmentExecution(long bookId, AppointmentStateEnum stateEnum) {
    this.bookId = bookId;
    this.state = stateEnum.getState();
    this.stateInfo = stateEnum.getStateInfo();
  }

  //ԤԼ�ɹ�������
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
