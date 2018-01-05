package com.wxn.upload.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
public class FtpFileHandler extends FileHandler {
    private String hostName;
    private String port;
    private String userName;
    private String passWord;
    private String path;

    public FtpFileHandler(String hostName, String port, String userName, String passWord, String path) {
        this.setHostName(hostName);
        this.setPort(port);
        this.setUserName(userName);
        this.setPassWord(passWord);
        this.setPath(path);
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean mkdir(String dest) {
        return false;
    }

    @Override
    public boolean rename(String dest) {
        return false;
    }

    @Override
    public void move(String dest, String names) {

    }

    @Override
    public void move(String dest, String[] names) {

    }

    @Override
    public void store(MultipartFile file, String path) throws IllegalStateException, IOException {

    }
}