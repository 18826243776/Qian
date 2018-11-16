package com.yue.thread;

/**
 * Created by 千里明月 on 2018/11/14.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        for (int i = 0; i < 10; i++) {
            if (i>5){
                Test test1=new Test();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test.tes4();
                    }
                }).start();
            }else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test.tes4();
                    }
                }).start();
            }
        }
    }


    private synchronized void tes() {
        System.out.println(Thread.currentThread()+"线程进入");
        try {
            System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"线程退出");
    }

    private static synchronized void tes1() {
        System.out.println(Thread.currentThread()+"线程进入");
        try {
            System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"线程退出");
    }

    private void tes2() {
        synchronized (this) {
            System.out.println(Thread.currentThread()+"线程进入");
            try {
                System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"线程退出");
        }
    }

    private void tes3() {
        synchronized (Test.class) {
            System.out.println(Thread.currentThread()+"线程进入");
            try {
                System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"线程退出");
        }
    }

    private void tes4() {
        String str = "";
        synchronized (str) {
            System.out.println(Thread.currentThread()+"线程进入");
            try {
                System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"线程退出");
        }
    }

}
