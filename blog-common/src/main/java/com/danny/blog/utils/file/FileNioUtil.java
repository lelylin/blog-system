package com.danny.blog.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Danny on 2019/6/10
 */
public class FileNioUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileNioUtil.class);

    private static String filePath = System.getProperty("user.dir") + "\\file\\";

    /**
     * 读取bytes返回数据
     */
    public static String readBytes(String fileName) throws Exception {
        return readBytes(Paths.get(filePath + fileName), "utf-8");
    }

    /**
     * 读取bytes返回数据
     *
     * @param fileName
     * @param charset
     * @return
     * @throws Exception
     */
    public static String readBytes(String fileName, String charset) throws Exception {
        return readBytes(Paths.get(filePath + fileName), charset);
    }

    /**
     * 写入bytes返回文件名
     *
     * @param string
     * @param suffix
     * @return
     * @throws Exception
     */
    public static String writeBytes(String string, String suffix) throws Exception {
        return writeBytes(string.getBytes(), suffix);
    }

    /**
     * 写入base64返回文件名
     *
     * @param base64
     * @return
     * @throws Exception
     */
    public static String writeBase64(String base64) throws Exception {
        String suffix = "." + base64.substring(base64.indexOf("/") + 1, base64.indexOf(";"));
        base64 = base64.substring(base64.indexOf(',') + 1, base64.length());
        return writeBytes(Base64Utils.decodeFromString(base64), suffix);
    }

    /**
     * 写入words返回文件名
     *
     * @param string
     * @param suffix
     * @return
     * @throws Exception
     */
    public static String writeWords(String string, String suffix) throws Exception {
        return writeBytes(string.getBytes("utf-8"), suffix);
    }

    /**
     * 写入words返回文件名
     *
     * @param string
     * @param suffix
     * @param charset
     * @return
     * @throws Exception
     */
    public static String writeWords(String string, String suffix, String charset) throws Exception {
        return writeBytes(string.getBytes(charset), suffix);
    }

    /**
     * 读取bytes返回数据
     *
     * @param path
     * @param charset
     * @return
     * @throws Exception
     */
    private static String readBytes(Path path, String charset) throws Exception {
        FileChannel readChannel = FileChannel.open(path, StandardOpenOption.READ);
        MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
        byte[] bytes = new byte[mappedByteBuffer.limit()];
        mappedByteBuffer.get(bytes);
        return new String(bytes, charset);
    }

    /**
     * 写入bytes返回文件名
     *
     * @param bytes
     * @param suffix
     * @return
     * @throws Exception
     */
    private static String writeBytes(byte[] bytes, String suffix) throws Exception {
        Path path = Paths.get(filePath, createNewFileName(suffix));
        while (Files.exists(path))
            path = Paths.get(filePath, createNewFileName(suffix));
        FileChannel writeChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        MappedByteBuffer mappedByteBuffer = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
        mappedByteBuffer.put(bytes);
        return path.getFileName().toString();
    }

    /**
     * 生成随机文件名
     *
     * @param suffix
     * @return
     */
    public static String createNewFileName(String suffix) {
        return FileUtilDate.getCurrentDateTime("yyyyMMdd-HHmmss-") + FileUtilMath.getRandomHex6() + suffix;
    }

    static {
        logger.info("bean init AuuUtilIO");
    }

    public static void main(String[] args) {
        String su = ".txt";
        byte[] bye= {99,9,0};
        String tt = "";
        String yy = "";
        try {
            yy =writeWords("yuuuuuuuuuuuuuuuukhjngngffdadfgg gbfds发给你和共同繁荣的地方", su);
            tt = writeBytes(bye, su);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("tt:"+tt);
        System.err.println("yy:"+yy);
    }
}
