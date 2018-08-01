package com.yue.socket.url;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 千里明月 on 2018/7/25.
 */
public class URLConnection {
    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://www.baidu.com");
        try (
                InputStream in = url.openStream()
        ) {
            int i = 0;
            byte[] buffer=new byte[102];
            while ((i = in.read(buffer)) != -1) {
                System.out.println(new String(buffer));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        URL url = new URL("http://www.baidu.com");
        Object content = url.getContent();
        System.out.println(content);
    }

    @Test
    public void test3() throws IOException {
        URL url = new URL("http://www.baidu.com");
        java.net.URLConnection urlConnection = url.openConnection();
        System.out.println(urlConnection);
    }
}
