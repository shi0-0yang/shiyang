package com.shiyang.designPatterns.factorymethod;

/**
 * 工厂方法：弥补了简单工厂不易于扩展的缺点
 * 给一个产品族定义一个接口，产品族下边定义具体的产品实现。（产品族的纵向的，接口和实现类，或者抽象类和子类）创建产品族工厂接口，
 * 不同的产品工厂创建不同的产品。
 */
public interface Farm {
    Fruiter getBean();
}
