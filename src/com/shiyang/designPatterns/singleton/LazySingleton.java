package com.shiyang.designPatterns.singleton;

/**
 * 懒汉式单例：线程保护：synchronized
 */
public class LazySingleton {
    private volatile static LazySingleton instance=null;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){// 静态，同步，公开访问点
        //再次检查实例是否存在，如果不存在才真正的创建实例
        try{
            synchronized (LazySingleton.class){
                if(instance!=null){

                }else {
                    Thread.sleep(100);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return instance;
    }
}
