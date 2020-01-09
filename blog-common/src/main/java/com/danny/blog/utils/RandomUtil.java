package com.danny.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Danny on 2019/4/16
 * 生成随机文件名：当前年月日时分秒+五位随机数
 */
public class RandomUtil {

    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return str + rannum;// 当前时间+五位随机数
    }

    public static void main(String[] args) {
        String fileName = RandomUtil.getRandomFileName();
        System.out.println("fileName:"+fileName);
    }

}
