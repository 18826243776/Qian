package com.yue.socket.InetAddress;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by 千里明月 on 2018/7/23.
 */
public class MyInetAddress {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress name = InetAddress.getByName("www.baidu.com");
        System.out.println(name);
        InetAddress address = InetAddress.getByName("163.177.151.110");
        System.out.println(address.getHostName());
        InetAddress name1 = InetAddress.getByName("192.168.80.126");
        System.out.println(name1.getHostName());
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }

        System.out.println(InetAddress.getLocalHost());
    }

    @Test
    public void test() throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("192.168.50.9");
        System.out.println(byName.getAddress());
        System.out.println(byName.getHostAddress());
        long timeMillis = System.currentTimeMillis();
        System.out.println(byName.getCanonicalHostName());//寻找dns服务器解析ip  花费很长的时间
        System.out.println(System.currentTimeMillis()-timeMillis);
    }

    @Test
    public void test1() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        System.out.println(address.isAnyLocalAddress());
        InetAddress address1 = InetAddress.getByName("0.0.0.0");
        System.out.println(address1.isAnyLocalAddress());
    }

    @Test
    public void test2() throws IOException {
        InetAddress address = InetAddress.getByName("192.168.50.74");
        System.out.println(address.isReachable(10000));
    }

    @Test
    public void test3() throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        NetworkInterface anInterface = NetworkInterface.getByInetAddress(address);
        System.out.println(anInterface.getDisplayName());

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface networkInterface = interfaces.nextElement();
            System.out.println(networkInterface.getName());
        }
    }
}
