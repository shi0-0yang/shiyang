package com.shiyang.designPatterns.abstractfactory;

public class NorthernFruit implements  Fruit{
    private String name;

    public NorthernFruit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
