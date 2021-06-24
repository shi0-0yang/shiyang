package com.shiyang.thread;

/**
 * 匿名内部类
 * 适用于启动线程次数较少的环境
 */
public class CreateThread3 {
    public static void main(String[] args) {
        //方式一：相当于继承了Thread类，作为子类重写了run()实现
        new Thread(){
            public void run(){
                System.out.println("匿名内部类创建线程方式一。。。");
            };
        }.start();

        //方式二：实现Runnable,Runnable作为内部匿名类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类创建线程方式二。。。");
            };
        }).start();
    }
}
