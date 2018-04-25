package com.zryq.cms.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by 锐 on 2017/11/13.
 */
public class FreeMarkerUtil {

    public static Template getTemplate(String name) {
        Template template = null;

        try {
            Configuration configuration = new Configuration();
            String rootPath = System.getProperty("user.dir");
            File file = new File("D:\\project\\zryq-cms\\src\\main\\webapp\\assets\\templates");
            configuration.setDirectoryForTemplateLoading(file);
            template = configuration.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    public static void print(String name, Map<String, Object> rootMap) {
        Template template = getTemplate(name);
        try {
            template.process(rootMap, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成文件
     *
     * @param name    模板名称
     * @param rootMap 数据
     * @param outFile 输出位置
     */
    public static void createHtml(String name, Map<String, Object> rootMap, String outFile) {
        FileWriter fileWriter = null;
        try {

            File file = new File("d:\\freemarker\\" + outFile);
            if (file.exists()) {
                System.out.println("file exists");
            } else {
                System.out.println("file not exists, create it ...");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            fileWriter = new FileWriter("d:\\freemarker\\" + outFile);
            Template template = getTemplate(name);
            try {
                template.process(rootMap, fileWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
