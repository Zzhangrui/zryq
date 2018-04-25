package com.zryq.cms.admin.controller;

import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.FileUtil;
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
        FileAttr fileAttr = new FileAttr();
        if (file != null && !file.isEmpty()) {

            FileUtil fu = new FileUtil();
            String fileName = file.getOriginalFilename();
            //String fileType = fileName.substring(fileName.lastIndexOf("."));
            JsonResult jsonResult =
                    fu.saveFile(request, file, "attached" + File.separator + dirPath);

            if (jsonResult.isSuccess()) {
                fileAttr.setCode("0");
                fileAttr.setMsg("上传成功");
                fileAttr.setFileName(fileName);
                fileAttr.setUrl(jsonResult.getData().toString());
            } else {
                fileAttr.setMsg("上传失败，请检查文件大小及格式是否正常");
                fileAttr.setCode("10086");
            }
        }
        response.setContentType("text/html");

        return fileAttr;
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
