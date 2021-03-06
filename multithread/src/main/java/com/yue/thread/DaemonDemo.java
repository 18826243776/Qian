package com.yue.thread;

/**
 * Created by 13 on 2017/5/4.
 */
public class DaemonDemo {
    public static class DaemonT extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new DaemonT();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);

    }
}
