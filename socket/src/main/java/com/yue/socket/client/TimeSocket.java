package com.yue.socket.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/8/8.
 */
public class TimeSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time.nist.gov", 13);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[100];
        int i=0;
        while ((i=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }
    }
}
