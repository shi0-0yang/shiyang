package com.shiyang.Collection;

import java.util.*;

public class MyList {
    public static void main(String[] args) {
        //  list含arraylist,linkedlist,vector
        ArrayList<Integer> arrayList=new ArrayList<>();
        Vector<Integer> vector=new Vector<>();
        arrayList.add(1);
        vector.add(1);

        LinkedList<Character> linkedList=new LinkedList<>();
        linkedList.add('a');

        //输出
        System.out.printf(arrayList.toString());
        System.out.printf(linkedList.toString());
        System.out.printf(vector.toString());

        //清理缓存
        arrayList.clear();
        vector.clear();
        linkedList.clear();
    }
}
