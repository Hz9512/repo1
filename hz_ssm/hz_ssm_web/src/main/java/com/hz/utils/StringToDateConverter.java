package com.hz.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param s        传进来的字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH-mm");
        //把字符串转换成日期
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
