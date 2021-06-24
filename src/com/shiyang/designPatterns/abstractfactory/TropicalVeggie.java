package com.shiyang.designPatterns.abstractfactory;

public class TropicalVeggie implements Veggle {
    private String name;

    public TropicalVeggie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
