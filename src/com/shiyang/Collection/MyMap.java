package com.shiyang.Collection;

import java.util.HashMap;
import java.util.TreeMap;

public class MyMap {
    public static void main(String[] args) {
        //map集合包括hashMap,hashTable,treeMap
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("name","alex");

        TreeMap<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("age",17);

        //输出
        System.out.printf(hashMap.toString());
        System.out.printf(treeMap.toString());

        //清理缓存
        hashMap.clear();
        treeMap.clear();
    }
}
