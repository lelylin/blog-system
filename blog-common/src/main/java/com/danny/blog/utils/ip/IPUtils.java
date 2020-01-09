package com.danny.blog.utils.ip;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Danny on 2019/2/13
 * IP工具
 */
public class IPUtils {

    public static final String SEMICOLON = ";";

    // 代理的客户IP-header
    public static final String[] HEADERS_TO_TRY = {
            "X-REAL-IP",
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR",
            "REMOTE-HOST"
    };


    /**
     * 获取客户端的IP地址
     *
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String clientIp = _getClientIp(request);
        if (null != clientIp && !clientIp.trim().isEmpty()) {
            return clientIp;
        }
        return request.getRemoteAddr();
    }

    private static String _getClientIp(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取服务器自身的IP
     *
     * @return
     */
    public static String getServerLocalIP() {
        if (isWin()) {
            return getWinIP();
        } else {
            return getLinuxIP();
        }
    }

    /**
     * 获取 Linux 的IP
     */
    private static String getLinuxIP() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();

            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                System.out.println(netInterface.getName());
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    addr = (InetAddress) addresses.nextElement();
                    //  是IPV4地址
                    if (addr != null && addr instanceof Inet4Address) {
                        ip += addr.getHostAddress();
                        ip += SEMICOLON;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ip.indexOf(SEMICOLON) < ip.lastIndexOf(SEMICOLON)) {
            ip = ip.replace("127.0.0.1", "");
            ip = ip.replace(SEMICOLON + SEMICOLON, "");
        }
        if (ip.startsWith(SEMICOLON)) {
            ip = ip.substring(1);
        }
        if (ip.endsWith(SEMICOLON)) {
            ip = ip.substring(0, ip.length() - 1);
        }

        return ip;
    }

    /**
     * 获取 windows 的IP
     *
     * @return
     */
    private static String getWinIP() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException e) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    /**
     * 判断是否是windows系统
     */
    private static boolean isWin() {
        String osName = getOSName();
        if (null == osName || osName.isEmpty()) {
            return false;
        }
        if (osName.contains("win") || osName.contains("Win")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取操作系统名
     */
    private static String getOSName() {
        Properties properties = System.getProperties();
        return properties.getProperty("os.name");
    }


    public static long ip2Long(String localIp) {
        long result = 0;
        String strIp = firstIp(localIp);
        if (null == strIp) {
            return 0;
        }
        strIp = strIp.trim();
        if (!isIpv4(strIp)) {
            return 0;
        }
        try {
            String[] ipAddressInArray = localIp.split("\\.");
            if (null == ipAddressInArray || ipAddressInArray.length != 4) {
                return 0;
            }
            for (int i = 0; i < ipAddressInArray.length; i++) {
                long ip = Long.parseLong(ipAddressInArray[3 - i]);
                result |= ip << (i * 8);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String long2Ip(Long ipValue) {
        try {
            InetAddress inet = InetAddress.getByName("" + ipValue);
            String address = inet.getHostAddress();
            return address;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isIpv4(String ipStr) {
        if (null == ipStr) {
            return false;
        } else if (ipStr.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$")) {
            return true;
        }
        return false;
    }

    private static String firstIp(String ip) {
        if (null == ip) {
            return ip;
        }
        if (!ip.contains(SEMICOLON)) {
            return ip;
        } else {
            return ip.substring(0, ip.indexOf(SEMICOLON));
        }

    }
}
