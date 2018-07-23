package com.yue.socket.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/7/19.
 */
public class FileTransferCilent {
    public static final String TEMP_FILE = "F:/FFOutput/钢琴曲-卡农.mp4";
    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 8081;

    public static void main(String[] args) {
        FileTransferCilent fileTransferCilent = new FileTransferCilent();
        File file = new File(TEMP_FILE);
        fileTransferCilent.sendFile(file);
        System.out.println();
    }

    private void sendFile(File file) {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            OutputStream out = socket.getOutputStream();
//            InputStream inputServer = socket.getInputStream();
            FileInputStream input = new FileInputStream(file);
//            out.write(file.getName().getBytes());
//            out.write((file.length() + "").getBytes());
//            out.flush();
            byte[] buffer = new byte[2048];
            int i = 0;
            int progress = 0;
            int sum = 0;
            System.out.println(file.length());
            while ((i = input.read(buffer)) != -1) {
                out.write(buffer);
                int temp = progress;
                sum += i;
                progress = (int) (sum / (float) file.length() * 100);
                if (progress > temp) {
                    System.out.println("--" + (progress) + "%--");
                }
            }
            System.out.println("文件上传完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
