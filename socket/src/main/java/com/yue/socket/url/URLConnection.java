package com.yue.socket.url;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
            byte[] buffer = new byte[102];
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
        System.out.println(content.getClass().getName());
    }

    @Test
    public void test3() throws IOException {
        URL url = new URL("https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D0%2C0%2C498%2C329%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=bd7d3d5bff03918fc39e678a6c0d0aa7/7acb0a46f21fbe09b539a9af63600c338744ad22.jpg");
        java.net.URLConnection urlConnection = url.openConnection();
        System.out.println(urlConnection);
    }

    @Test
    public void test4() throws IOException {
        URL url = new URL("http://www.baidu.com");
        String path = url.getPath();
        System.out.println(path);
    }

    @Test
    public void test5() throws IOException {
        URL url = new URL("https://my.oschina.net/u/3490860/blog/write");
        java.net.URLConnection connection = url.openConnection();
        connection.setAllowUserInteraction(true);
        InputStream inputStream = connection.getInputStream();

        System.out.println(inputStream);
    }

    @Test
    public void test6() throws IOException {
        URL url = new URL("https://www.cnblogs.com/chenzhiyu/p/7998539.html");
        java.net.URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setRequestMethod("HEAD");
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
