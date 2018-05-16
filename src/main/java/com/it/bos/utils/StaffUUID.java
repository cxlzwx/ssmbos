package com.it.bos.utils;/**
 * Created by Think on 2018/5/8.
 */

import java.util.UUID;

/**
 * @ClassName StaffUUID
 * @Description UUID生成工具类
 * @Author Think
 * @Date 2018/5/8 19:34
 * @Version 1.0
 */
public class StaffUUID {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
