package com.zryq.cms.front.controller;

import com.zryq.cms.common.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("verifyCode")
public class VerifyCodeController {

    private static String prefix = "login";

    /**
     * 用于生成带四位数字验证码的图片
     */
    @RequestMapping(value = "/captcha/{type}")
    @ResponseBody
    public String imageCode(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        OutputStream os = response.getOutputStream();
        //返回验证码和图片的map
        Map<String,Object> map = CaptchaUtil.getImageCode(86, 37, os);

        String VerifyCodeType = CaptchaUtil.LOGIN_SIMPLE_CAPTCHA;
        if(!prefix.equalsIgnoreCase(type)){
            VerifyCodeType = CaptchaUtil.REGISTER_SIMPLE_CAPTCHA;
        }
        request.getSession().setAttribute(VerifyCodeType, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime",new Date().getTime());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            return "";
        }   finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
        return null;
    }
}
