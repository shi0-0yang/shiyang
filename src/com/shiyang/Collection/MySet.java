package com.shiyang.Collection;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MySet {
    public static void main(String[] args) {
        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add((int)3e1);
        hashSet.add((int)0b1010);

        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(1);

        //输出
        System.out.println(hashSet.toString());
        System.out.println(treeSet.toString());

        //清理缓存
        hashSet.clear();
        treeSet.clear();
    }
}
