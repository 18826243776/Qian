package com.yue.socket.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/7/19.
 */
public class FileTransferServer {
    public static final String TEMP_FILE = "D:/tets.mp4";
    public static final int SERVER_PORT = 8081;

    public static void main(String[] args) {
        FileTransferServer fileTransferServer = new FileTransferServer();
        fileTransferServer.accept();
    }

    private void accept() {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            Socket client = null;
            FileOutputStream output = null;
            while (true) {
                try {
                    client = server.accept();
                    InputStream input = client.getInputStream();
                     output = new FileOutputStream(new File(TEMP_FILE));
                    int i=0;
                    byte[] buffer= new byte[2015];
                    while ((i=input.read(buffer))!=-1){
                        output.write(buffer);
                        System.out.println(new String(buffer));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (!client.isClosed()) {
                        client.close();
                    }
                    output.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
