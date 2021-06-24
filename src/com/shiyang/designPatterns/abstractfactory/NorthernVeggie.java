package com.shiyang.designPatterns.abstractfactory;

public class NorthernVeggie implements Veggle {
    private String name;

    public NorthernVeggie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
