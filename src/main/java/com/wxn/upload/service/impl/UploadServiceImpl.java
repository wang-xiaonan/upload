package com.wxn.upload.service.impl;

import com.wxn.upload.common.FileHandler;
import com.wxn.upload.common.UploadType;
import com.wxn.upload.domain.FileHandlerFactory;
import com.wxn.upload.domain.UploadResult;
import com.wxn.upload.service.UploadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private FileHandlerFactory fhf;
    @Value("${upload.path}")
    private String filePath;

    @Override
    public String copyImage(BufferedImage buff, String extension, String formatName) {
        return null;
    }

    @Override
    public String uploadImage(BufferedImage buff, String extension, String formatName) {
        return null;
    }

    @Override
    public void upload(String url, UploadType type, UploadResult result) {

    }

    @Override
    public void upload(MultipartFile partFile, UploadType type, UploadResult result) throws IOException {
        if (partFile == null) {
            result.setMessage("no file upload");
            return;
        }
        // TODO 在这里面要有真是文件名，服务器文件名，文件相对于应用的地址
        String fileName = partFile.getOriginalFilename();
        String ext = FilenameUtils.getExtension(fileName);
        String randomFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext;

        // 跟cms一样，可以在这分开成本地上传和ftp上传方式
        FileHandler fileHandler = fhf.getFileHandler();
        fileHandler.store(partFile,randomFileName);
        // 上传到本地应用
//        File file = new File(servletContext.getRealPath("/") + filePath + "/" + type.name().toLowerCase() + "/" + randomFileName);
//        File parent = file.getParentFile();
//        if (!parent.exists()) {
//            parent.mkdirs();
//        }
//        try {
//            partFile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        result.setFileName(fileName);
    }
}
