package com.danny.blog.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Danny on 2019/6/10
 */
public class FileUtilMath {

    private static final Logger logger = LoggerFactory.getLogger(FileUtilMath.class);

    /**
     * 生成六位十六进制随机数
     * @return
     */
    public static String getRandomHex6() {
        return String.format("%06x", new Random().nextInt(16777215));
    }

    /**
     * 判断是否为正整数
     * @param number
     * @return
     */
    public static boolean isMatches(String number) {
        return Pattern.compile("^[1-9]+[0-9]*$").matcher(number).find();
    }

    /**
     * 判断是否为小数
     * @param number
     * @return
     */
    public static boolean isNumber(String number) {
        return Pattern.compile("^([0-9]*[.][0-9]*)$").matcher(number).find();
    }

    static {
        logger.info("bean init com.auuwako.webapp.blog.service.AuuUtilMath");
    }
}
