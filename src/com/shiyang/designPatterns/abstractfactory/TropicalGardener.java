package com.shiyang.designPatterns.abstractfactory;

/**
 * 管理热带农场的园丁
 */
public class TropicalGardener implements Gardener {
    //热带水果
    public Fruit createFruit(String name){
        return new TropicalFruit(name);
    }

    //热带蔬菜
    public Veggle createVeggie(String name){
        return new TropicalVeggie(name);
    }
}
