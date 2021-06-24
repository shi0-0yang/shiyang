package com.shiyang.designPatterns.factorymethod;

public class BananaFarm implements  Farm {
    @Override
    public Fruiter getBean() {
        return new Banana();
    }
}
