package com.yue.thread;

/**
 * Created by 千里明月 on 2018/11/16.
 */
public class MyThreadGroup implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("线程组1");
        Thread t1 = new Thread(threadGroup, new MyThreadGroup(), "t1");
        Thread t2 = new Thread(threadGroup, new MyThreadGroup(), "t2");
        t1.start();
        t2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getThreadGroup().getName()+"---"+Thread.currentThread().getName());
    }
}
