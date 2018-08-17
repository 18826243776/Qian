package com.yue.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 千里明月 on 2018/8/12.
 */
public class RedirectServer {

    ExecutorService executorService = Executors.newFixedThreadPool(100);

    private void startServer() {
        try (
                ServerSocket serverSocket = new ServerSocket(8080);
        ) {
            while (true) {
                Socket accept = null;
                accept = serverSocket.accept();
                System.out.println("接入一个客户端  ");
                executorService.submit(new MyThread(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MyThread implements Callable {

        private Socket socket;

        public MyThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public Object call() throws Exception {
            try (
                    InputStream inputStream = socket.getInputStream();
                    Reader reader = new InputStreamReader(new BufferedInputStream(inputStream));
                    Writer out = new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()))
            ) {
                StringBuilder sb = new StringBuilder(100);
                while (true) {
                    int data = reader.read();
                    sb.append((char) data);
                    if (data == '\r' || data == '\n' || data == -1) {
                        break;
                    }
                }

                if (sb.toString().indexOf("HTTP") != -1) {
                    out.write("HTTP/1.1 302 FOUND\r\n");
                    out.write("Date: " + new Date() + "\r\n");
                    out.write("Server: Redirector \r\n");
                    out.write("Location: http://www.baidu.com\r\n");
                    out.write("Content-type: text/html\r\n\r\n");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }


    public static void main(String[] args) {
        RedirectServer redirectServer = new RedirectServer();
        redirectServer.startServer();
    }
}
