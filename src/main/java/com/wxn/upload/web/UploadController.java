package com.wxn.upload.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxn.upload.common.UploadType;
import com.wxn.upload.domain.UploadResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangxiaonan on 2018/1/2.
 */
@RestController
@RequestMapping("upload/")
public class UploadController extends UploadControllerAbstract {
    /**
     * 图片上传
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "image")
    public String uploadImage(HttpServletRequest request, HttpServletResponse response) {
        UploadResult result = new UploadResult();
        upload(request, response, UploadType.IMAGE, result);
        return result.getFileName();
    }

    /**
     * 上传文件
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "file", produces = "application/json; charset=UTF-8")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response) {
        UploadResult result = new UploadResult();
        upload(request, response, UploadType.FILE, result);
        return result.getFileUrl();
    }
}
