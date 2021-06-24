package com.shiyang.thread;

/**
 * 实现Runnable接口
 * 若要启动线程，需要new Thread(Runnable target),再由thread对象调用start()方法启动线程
 */
public class CreateThread2 implements Runnable{
    public void run(){
        System.out.println("implements Runnable is running");
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CreateThread2());
        Thread thread2 = new Thread(new CreateThread2());
        thread1.start();
        thread2.start();
    }
}
