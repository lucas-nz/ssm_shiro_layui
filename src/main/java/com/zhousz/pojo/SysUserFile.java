package com.zhousz.pojo;

public class SysUserFile {
    private Integer fileId;

    private Long userId;

    private String fileUrl;

    private String fileName;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    @Override
    public String toString() {
      return "SysUserFile [fileId=" + fileId + ", userId=" + userId + ", fileUrl=" + fileUrl + ", fileName=" + fileName
          + "]";
    }
    
    
}