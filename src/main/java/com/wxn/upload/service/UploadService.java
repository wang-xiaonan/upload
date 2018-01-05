package com.wxn.upload.service;

import com.wxn.upload.common.UploadType;
import com.wxn.upload.domain.UploadResult;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
public interface UploadService {

    /**
     * 服务器端复制图片，可对图片做一些处理
     *
     * @param buff
     * @param extension
     * @param formatName
     * @return
     */
    public String copyImage(BufferedImage buff, String extension, String formatName);

    /**
     * 上传图片
     * @param buff
     * @param extension
     * @param formatName
     * @return
     */
    public String uploadImage(BufferedImage buff, String extension, String formatName);

    /**
     * 根据图片链接上传文件到服务器
     * @param url
     * @param type
     * @param result
     */
    public void upload(String url, UploadType type, UploadResult result);

    /**
     * 上传文件
     * @param partFile
     * @param type
     * @param result
     */
    public void upload(MultipartFile partFile, UploadType type, UploadResult result) throws IOException;
}
