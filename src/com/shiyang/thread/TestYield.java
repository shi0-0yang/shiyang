package com.shiyang.thread;

/**
 * 线程礼让的几个特点：
 * 礼让线程，让当前正在执行的线程暂停，但不阻塞
 * 将线程从运行状态转为就绪状态
 * 让cpu重新调度，礼让不一定成功！看cpu心情
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--begin");
        Thread.yield(); //线程礼让
        System.out.println(Thread.currentThread().getName() + "--end");
    }
}
