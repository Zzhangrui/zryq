package com.zryq.cms.config.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 锐 on 2017/10/20.
 */
public class FreemarkerUtil {

    public static Template getTemplate(String name) {
        Template temp = null;
        try {
            Configuration cfg = new Configuration();
            File file = new File("/WEB-INF/templates");
            cfg.setDirectoryForTemplateLoading(file);
            temp = cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static boolean produceHtml(String tempName, Map<String, Object> maps, String outFile) {
        boolean isSuccess = true;
        FileWriter out = null;

        try {
            out = new FileWriter(outFile);
            Template template = getTemplate(tempName);
            template.process(maps, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }
}
