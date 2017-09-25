package com.zhousz.enums;


/**
 * ʹ��ö�ٱ��峣�������ֵ�
 * @author ZhouSZ
 *
 */
public enum AppointmentStateEnum {
  
  SUCCESS(1, "ԤԼ�ɹ�"), NO_NUMBER(0, "��治��"), REPEAT_APPOINT(-1, "�ظ�ԤԼ"), INNER_ERROR(-2, "ϵͳ�쳣") ;
  
  private int state;
  
  private String stateInfo;
  
  private AppointmentStateEnum(int state, String stateInfo){
    this.state = state;
    this.stateInfo = stateInfo;
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
  
  public static AppointmentStateEnum stateOf(int index){
    
    for (AppointmentStateEnum state : values()) {
      if (state.getState() == index) {
        return state;
      }
    }
    return null;
  }
  
}
