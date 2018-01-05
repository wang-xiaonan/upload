package com.wxn.upload.web;

import com.wxn.upload.common.UploadType;
import com.wxn.upload.domain.UploadResult;
import com.wxn.upload.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 处理数据和结果
 * Created by wangxiaonan on 2018/1/2.
 */
public abstract class UploadControllerAbstract {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final String FILE_PATH = "path";
    @Autowired
    private UploadService uploadService;

    /**
     * @param request
     * @param response
     * @param type
     */
    protected void upload(HttpServletRequest request, HttpServletResponse response, UploadType type, UploadResult result) {
        MultipartFile partFile = null;
        String path = null;
        // 判断是附件链接还是本地上传
        try {
            partFile = getMultipartFile(request);
            uploadService.upload(partFile, type, result);
        } catch (IllegalStateException e) {
//            path = request.getParameter(FILE_PATH);
//            uploadService.upload(path, type, result);
        } catch (IOException e) {

        }
    }

    protected MultipartFile getMultipartFile(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        if (CollectionUtils.isEmpty(fileMap)) {
            throw new IllegalStateException("No upload file found!");
        }
        return fileMap.entrySet().iterator().next().getValue();
    }
}
