package com.wxn.upload.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
public abstract class FileHandler {
    public static FileHandler getLocalFileHandler(String path) {
        return new LocalFileHandler(path);
    }

    public static FileHandler getFtpFileHandler(String hostName, String port, String userName, String passWord, String path) {
        return new FtpFileHandler(hostName, port, userName, passWord, path);
    }

    public abstract boolean mkdir(String dest);

    public abstract boolean rename(String dest);

    public abstract void move(String dest, String names);

    public abstract void move(String dest, String[] names);

    public abstract void store(MultipartFile file, String fileName)
            throws IllegalStateException, IOException;
}
