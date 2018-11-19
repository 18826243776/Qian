package com.yue.socket.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSniffer {
    public static void main(String[] args) {
        InetAddress group=null;
        int port=80;

        try{
            group = InetAddress.getByName("wwww.baidu.com");
        }catch (IOException e){
            e.printStackTrace();
        }
        MulticastSocket ms=null;
        try{
            ms=new MulticastSocket(port);
            ms.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
