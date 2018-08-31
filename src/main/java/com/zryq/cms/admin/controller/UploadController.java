package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.service.FileOperateService;
import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 锐 on 2017/8/23.
 */
@Controller
public class UploadController {


    @Autowired
    private FileOperateService fileOperateService;

    /**
     * @param file
     * @param request
     * @param response
     * @param dirPath  保存在应用名/attache/dirPath/....目录
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public FileAttr upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String dirPath) {
        return  fileOperateService.upload(file,request,response,dirPath);
    }


    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath) {
        try {
            filePath = URLDecoder.decode(filePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        FileUtil fileUtil = new FileUtil();
        try {
            fileUtil.download(response, request, filePath, null, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
