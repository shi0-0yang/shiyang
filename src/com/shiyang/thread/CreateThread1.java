package com.shiyang.thread;

/**
 * 继承Thread类，重写run方法
 */
public class CreateThread1 extends Thread {
    //重写父类的run方法
    public void run(){
        System.out.println(getName()+"is running...");
    }


    public static void main(String[] args) {
        CreateThread1 demo1 = new CreateThread1();
        CreateThread1 demo2 = new CreateThread1();
        demo1.start();
        demo2.start();
    }
}

