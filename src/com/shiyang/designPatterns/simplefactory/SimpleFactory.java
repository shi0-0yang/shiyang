package com.shiyang.designPatterns.simplefactory;

/**
 * 简单工厂：有n个类需要管理，设计n个类分配一个唯一标识，调用简单工厂模式需要传递标识，工厂根据传入标识创建对象
 */
public class SimpleFactory {
    public static Object getObject(String obj) {
        if (obj.equals("飞机")) {
            return new Airplane();
        } else if (obj.equals("火箭")) {
            return new Rocket();
        } else if (obj.equals("螺丝")) {
            return new Screw();
        } else {
            return null;
        }
    }
}
