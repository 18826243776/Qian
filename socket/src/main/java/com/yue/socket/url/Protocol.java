package com.yue.socket.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 千里明月 on 2018/7/25.
 */
public class Protocol {
    public static void main(String[] args) {
        testProtocol("ftp://192.168.50.64");
        testProtocol("telnet://192.168.50.103:80");
        testProtocol("file://fsdsdfd");
    }

    private static void testProtocol(String url) {
        URL u = null;
        try {
            u = new URL(url);
            System.out.println("支持" + u.getProtocol());
        } catch (MalformedURLException e) {
            System.out.println("不支持" + url.split(":")[0]);
        }
    }
}
