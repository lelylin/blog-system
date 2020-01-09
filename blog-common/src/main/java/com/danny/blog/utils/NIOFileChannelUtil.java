package com.danny.blog.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Danny on 2019/4/16
 */
public class NIOFileChannelUtil {

    /**
     * 读取txt文件
     */
    @SuppressWarnings("resource")
    public static void readTxt() {
        try {
            //定义缓冲区对象
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //通过文件输入流获取文件通道流对象
            FileChannel inFc = new FileInputStream("D:\\test.txt").getChannel();

            //读取数据
            buffer.clear();
            int length = inFc.read(buffer);
            System.out.println(new String(buffer.array(),0,length,"GBK"));
            inFc.close();

        }catch(Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * 写入txt 文件
     */
    @SuppressWarnings("resource")
    public static void writeTxt() {
        try {
            FileChannel outFc = new FileOutputStream("D:\\test.txt",true).getChannel();

            ByteBuffer byteBuffer = ByteBuffer.wrap("\r\n李白乘舟将欲行".getBytes("GBK"));

            outFc.write(byteBuffer);

            outFc.close();
        }catch(Exception e) {

        }
    }

    public static void main(String[] args) {
        readTxt();
        //writeTxt();
    }

}
