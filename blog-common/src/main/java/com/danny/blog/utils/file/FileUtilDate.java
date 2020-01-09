package com.danny.blog.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Danny on 2019/6/10
 */
public class FileUtilDate {

    private static final Logger logger = LoggerFactory.getLogger(FileUtilDate.class);

    static public String getCurrentDateTime(String pattern) {
        return new java.text.SimpleDateFormat(pattern).format(new Date());
    }


    static {
        logger.info("bean init AuuUtilDate");
    }
}
