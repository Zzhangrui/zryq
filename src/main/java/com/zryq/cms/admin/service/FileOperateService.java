package com.zryq.cms.admin.service;

import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/30
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FileOperateService {

    private static final String DEFAULT_FILE_DIR="attached";

    public FileAttr upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String dirPath) {
        FileAttr fileAttr = new FileAttr();
        if (file != null && !file.isEmpty()) {

            FileUtil fu = new FileUtil();
            String fileName = file.getOriginalFilename();
            JsonResult jsonResult =
                    fu.saveFile(request, file, DEFAULT_FILE_DIR+ File.separator + dirPath);

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
}
