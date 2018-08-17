package com.yue.socket.server;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URLConnection;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by 千里明月 on 2018/8/12.
 */
public class EchoServer {
    public static int DEFAOULT_PORT = 7;
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel;
        Selector selector;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(DEFAOULT_PORT));
        serverSocketChannel.configureBlocking(false);
        selector = Selector.open();

    }

    @Test
    public void nete(){
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor("F:\\不要说话.avi");
        System.out.println(contentTypeFor);
    }
}
