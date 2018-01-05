package com.wxn.upload.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
public class LocalFileHandler extends FileHandler {
    private String path;

    public LocalFileHandler(String path) {
        this.setPath(path);
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
    public void store(MultipartFile file, String fileName) throws IllegalStateException, IOException {
        File parent = new File(path);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File dest = new File(parent, fileName);
        file.transferTo(dest);
    }
}
