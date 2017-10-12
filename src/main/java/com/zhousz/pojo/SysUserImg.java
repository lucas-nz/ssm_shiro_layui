package com.zhousz.pojo;

public class SysUserImg {
    private Integer imgId;

    private Long userId;

    private String firstDir;

    private String imgName;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstDir() {
        return firstDir;
    }

    public void setFirstDir(String firstDir) {
        this.firstDir = firstDir == null ? null : firstDir.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }
}