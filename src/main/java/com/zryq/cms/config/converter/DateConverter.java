package com.zryq.cms.config.converter;

import com.google.common.base.Strings;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 锐 on 2017/9/4.
 * 时间转换器  让spring mvc 接收时间格式
 */
public class DateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        if (Strings.isNullOrEmpty(source)) {
            return null;
        }
        String pattern = source.length() == 10 ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

