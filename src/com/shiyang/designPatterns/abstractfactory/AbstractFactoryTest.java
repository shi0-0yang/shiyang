package com.shiyang.designPatterns.abstractfactory;

import junit.framework.TestCase;

public class AbstractFactoryTest extends TestCase {
    public void testCreate(){
        TropicalGardener tropicalGardener = new TropicalGardener();
        Fruit fruit1 = tropicalGardener.createFruit("热带水果");
        Veggle veggie1 = tropicalGardener.createVeggie("热带蔬菜");
        assertTrue(fruit1 instanceof TropicalFruit);
        assertTrue(veggie1 instanceof  TropicalVeggie);

        NorthernGardener northernGardener = new NorthernGardener();
        Fruit fruit2 = northernGardener.createFruit("北方水果");
        Veggle veggie2 = northernGardener.createVeggie("北方蔬菜");
        assertTrue(fruit2 instanceof NorthernFruit);
        assertTrue(veggie2 instanceof  NorthernVeggie);
    }
}