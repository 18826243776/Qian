package com.yue.socket.client;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/**
 * Created by 千里明月 on 2018/8/14.
 */
public class HTTPSClient {
    private static int port = 443;//https默认端口

    public static void main(String[] args) throws IOException {
        HTTPSClient httpsClient = new HTTPSClient();
        String host = "www.baidu.com";
        httpsClient.start(host);
    }

    private void start(String host) {
        SocketFactory factory = SSLSocketFactory.getDefault();
        try (
                SSLSocket socket = (SSLSocket) factory.createSocket(host, port)
        ) {
            SSLSession session = socket.getSession();
            System.out.println(session);
            //启用所有密码组
            String[] cipherSuites = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(cipherSuites);
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write("GET http://" + host + " HTTP/1.1\r\n");
//            out.write("Host: " + host + "\r\n");
            out.write("\r\n");
            out.flush();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            StringBuilder builder = new StringBuilder(1000);
            while (line != null && !line.trim().equals("")) {
                line = bufferedReader.readLine();
                builder.append(line+"\r\n");
            }
            System.out.println(builder.toString());
//            String search="s?wd=ds&rsv_spt=1&rsv_iqid=0xf03b31c60001cf1f&issp=1&f=3&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=0&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&prefixsug=ds&rsp=0&inputT=1678&rsv_sug4=1898";

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
