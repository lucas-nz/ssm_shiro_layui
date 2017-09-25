package com.zhousz.pojo;

public class TbSubject {
    private Integer subjectid;

    private String subjecttitle;

    private String subjectoptiona;

    private String subjectoptionb;

    private String subjectoptionc;

    private String subjectoptiond;

    private String subjectanswer;

    private String subjectparse;

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjecttitle() {
        return subjecttitle;
    }

    public void setSubjecttitle(String subjecttitle) {
        this.subjecttitle = subjecttitle == null ? null : subjecttitle.trim();
    }

    public String getSubjectoptiona() {
        return subjectoptiona;
    }

    public void setSubjectoptiona(String subjectoptiona) {
        this.subjectoptiona = subjectoptiona == null ? null : subjectoptiona.trim();
    }

    public String getSubjectoptionb() {
        return subjectoptionb;
    }

    public void setSubjectoptionb(String subjectoptionb) {
        this.subjectoptionb = subjectoptionb == null ? null : subjectoptionb.trim();
    }

    public String getSubjectoptionc() {
        return subjectoptionc;
    }

    public void setSubjectoptionc(String subjectoptionc) {
        this.subjectoptionc = subjectoptionc == null ? null : subjectoptionc.trim();
    }

    public String getSubjectoptiond() {
        return subjectoptiond;
    }

    public void setSubjectoptiond(String subjectoptiond) {
        this.subjectoptiond = subjectoptiond == null ? null : subjectoptiond.trim();
    }

    public String getSubjectanswer() {
        return subjectanswer;
    }

    public void setSubjectanswer(String subjectanswer) {
        this.subjectanswer = subjectanswer == null ? null : subjectanswer.trim();
    }

    public String getSubjectparse() {
        return subjectparse;
    }

    public void setSubjectparse(String subjectparse) {
        this.subjectparse = subjectparse == null ? null : subjectparse.trim();
    }

    @Override
    public String toString() {
      return "TbSubject [subjectid=" + subjectid + ", subjecttitle=" + subjecttitle + ", subjectoptiona="
          + subjectoptiona + ", subjectoptionb=" + subjectoptionb + ", subjectoptionc=" + subjectoptionc
          + ", subjectoptiond=" + subjectoptiond + ", subjectanswer=" + subjectanswer + ", subjectparse=" + subjectparse
          + "]";
    }
    
    
    
}