package com.yue.socket.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by 千里明月 on 2018/8/14.
 */
public class UDPSocketServer {
    private static final int port = 8080;

    public static void main(String[] args) {

        try (
                DatagramSocket socket = new DatagramSocket(port);
        ) {
            while (true){
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);
                String msg="welcom to my world";
                byte[] bytes = msg.getBytes("utf-8");
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length,request.getAddress(),request.getPort());
                socket.send(packet);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
