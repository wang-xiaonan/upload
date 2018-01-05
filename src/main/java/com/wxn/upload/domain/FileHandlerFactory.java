package com.wxn.upload.domain;

import com.wxn.upload.common.FileHandler;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.UUID;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
@Component
public class FileHandlerFactory {
    @Autowired
    private ServletContext servletContext;

    @Value("${upload.config.isFTP}")
    private Boolean isFTP;
    @Value("${upload.config.path}")
    private String path;
    @Value("${upload.ftp.hostname}")
    private String ftpHostName;
    @Value("${upload.ftp.port}")
    private String ftpPort;
    @Value("${upload.ftp.username}")
    private String ftpUsername;
    @Value("${upload.ftp.password}")
    private String ftpPassword;
    @Value("${upload.ftp.displaypath}")
    private String ftpDisplayPath;

    public FileHandler getFileHandler() {
        FileHandler fh = null;
        if (isFTP) {
            fh = FileHandler.getFtpFileHandler(ftpHostName, ftpPort, ftpUsername, ftpPassword, path);
        } else {
            // 服务器本地上传要获取绝对路径
            fh = FileHandler.getLocalFileHandler(servletContext.getRealPath("") + path);
        }
        return fh;
    }

}
