package com.yue.socket.client;

import java.net.*;

/**
 * Created by 千里明月 on 2018/8/14.
 */
public class UDPSocket {
    private static final int port =8080;
    private static final String host="localhost";

    public static void main(String[] args) {
        try(
                DatagramSocket socket = new DatagramSocket(0);
                ){
//            socket.setSoTimeout(200000);
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);
            System.out.println(new String(response.getData(),"utf-8"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
