package com.wxn.upload.domain;

/**
 * 上传结果
 * Created by wangxiaonan on 2018/1/2.
 */
public class UploadResult {
    private static final int STATUS_ERROR = 0;
    private static final int STATUS_SUCCESS = 1;

    private int status = STATUS_ERROR;
    private String message;
    private String fileUrl;
    private String fileName;
    private long fileLength;
    private String fileExtension;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
