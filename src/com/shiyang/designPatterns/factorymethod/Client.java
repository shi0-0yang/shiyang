package com.shiyang.designPatterns.factorymethod;

public class Client {
    public static void main(String[] args) {

        Farm farm = new AppleFarm();
        Fruiter fruiter = farm.getBean();

        Farm farm2 = new BananaFarm();
        Fruiter fruiter2 = farm2.getBean();

        System.out.println(fruiter instanceof Apple);
        System.out.println(fruiter2 instanceof Banana);
    }
}
