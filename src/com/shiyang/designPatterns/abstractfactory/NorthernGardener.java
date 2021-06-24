package com.shiyang.designPatterns.abstractfactory;

/**
 * 抽象工厂：工厂方法对于单一产品族够用，但对于多产品族就不行了
 * 一个农场管理两个族群的产品了
 * 管理北方农场的园丁
 */
public class NorthernGardener implements Gardener {
    //    北方的水果
    public Fruit createFruit(String name) {
        return new NorthernFruit(name);
    }

    //北方的蔬菜
    public Veggle createVeggie(String name) {
        return new NorthernVeggie(name);
    }
}
