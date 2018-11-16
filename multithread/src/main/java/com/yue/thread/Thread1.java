package com.yue.thread;

/**
 * Created by 千里明月 on 2018/11/15.
 */
public class Thread1 {
    private static Object object=new Object();

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("t1");
        T2 t2 = new T2("t2");
        t1.start();
        t1.join(3000);
        t2.start();
        Thread.sleep(10);
        synchronized (object){
            object.notifyAll();
        }
    }

    public static class T1 extends Thread{
        public T1(){
            super();
        }
        public T1(String name){
            super(name);
        }
        public void run(){
            synchronized (object){
                System.out.println(Thread.currentThread()+"线程进入");
                try {
                    System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
                    object.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"线程退出");
            }
        }
    }

    public static class T2 extends Thread{
        public T2(){
            super();
        }
        public T2(String name){
            super(name);
        }
        public void run(){
            synchronized (object){
                System.out.println(Thread.currentThread()+"线程进入");
                try {
                    System.out.println(Thread.currentThread()+"线程沉睡0.1秒");
                    object.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"线程退出");
            }
        }
    }
}
