package com.shiyang.designPatterns.factorymethod;

public class AppleFarm implements  Farm {
    @Override
    public Fruiter getBean() {
        return new Apple();
    }
}
