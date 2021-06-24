package com.shiyang.designPatterns.singleton;

/**
 * 饿汉式单例
 * 饿汉单例模式
 * 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
 */
public class EagerSingleton {
    private   static  EagerSingleton instance=new EagerSingleton();
    private EagerSingleton(){};
    public static EagerSingleton getInstance(){
        return instance;
    }
}
