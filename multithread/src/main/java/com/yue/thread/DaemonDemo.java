package com.yue.thread;

/**
 * Created by 千里明月 on 2018/11/16.
 */
public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        DaemonT t = new DaemonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
    }

    private static class DaemonT extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while (true){
                System.out.println(1);
            }
        }
    }
}
