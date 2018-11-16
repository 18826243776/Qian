package com.yue.thread;

/**
 * Created by 千里明月 on 2018/11/15.
 */
public class Thread2 {
    private static int number;
    private  static boolean flag = false;

    private static class t2 extends Thread {
        @Override
        public void run() {
            while (!flag) {
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t2 t2 = new t2();
        t2.start();
        Thread.sleep(1000);
        number = 32;
        flag = true;
    }

}
