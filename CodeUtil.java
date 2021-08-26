package com.cqxxty.security.admin.utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 生成各种code
 * @ClassName CodeUtil
 * @Author lei
 * @Date 2021/8/14 9:31
 * @Version 1.0
 */
public class CodeUtil {
    /**
     *  获取下一个企业code
     *  生成规则为创建年月日yyyyMMdd+3位顺序码
     *  如果当天数据超过999,则为4位顺序码
     * @param
     * @param serialNumber 当天总计多少个企业
     * @return java.lang.String
     * @author lei
     * @date 2021/8/14 9:32
     * @version v1.0
     */
    public static String getOrgCode(Integer serialNumber){
        String STR_FORMAT = "000";
        if(Objects.isNull(serialNumber)){
            return "001";
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateStr = today.format(fmt);
        serialNumber++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return dateStr+df.format(serialNumber);
    }

    /**
     *  获取下一个场景code
     *  生成规则为创建年月日yyyyMMdd+3位顺序码
     *  如果当天数据超过999,则为4位顺序码
     * @param serialNumber 当天总计多少个场景
     * @return java.lang.String
     * @author lei
     * @date 2021/8/14 9:35
     * @version v1.0
     */
    public static String getSceneCode(Integer serialNumber){
        String STR_FORMAT = "000";
        if(Objects.isNull(serialNumber)){
            return "001";
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateStr = today.format(fmt);
        serialNumber++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return dateStr+df.format(serialNumber);
    }

    public static String getProjectCode(Integer serialNumber){
        String STR_FORMAT = "000";
        if(Objects.isNull(serialNumber)){
            return "001";
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateStr = today.format(fmt);
        serialNumber++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return dateStr+df.format(serialNumber);
    }
}
