package com.shiyang.designPatterns.simplefactory;

public class Main {
    public static void main(String[] args) {
        Object airplane = SimpleFactory.getObject("飞机");
        System.out.println(airplane instanceof Airplane);

        Object rocket = SimpleFactory.getObject("火箭");
        System.out.println(rocket instanceof Rocket);

        Object screw = SimpleFactory.getObject("螺丝");
        System.out.println(screw instanceof Screw);
    }
}
