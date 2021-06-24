package com.sxy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUStruct {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here

        int resultLength = 0;
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                resultLength++;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;

        LruCache cache = new LruCache(k);
        List<Integer> resultList = new LinkedList<>();
        for (int[] operator : operators) {
            switch (operator[0]) {
                case 1:
                    cache.set(operator[1], operator[2]);
                    break;
                case 2:
                    Integer value = cache.get(operator[1]);
                    results[index++] = value == null ? -1 : value;
            }
        }
        return results;
    }

    class Node {
        public Node prev, next;
        private int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node head;
        private int size;

        public DoubleList() {
            super();
            this.head = null;
            this.size = 0;
        }

        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x) {
            head.prev.next = x;
            x.next = head;
            x.prev = head.prev;
            head.prev = x;
            this.size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            this.size--;
            x = null;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node node = head.prev;
            node.prev.next = head;
            head.prev = node.prev;
            node.prev = null;
            node.next = null;
            return node;
        }

        // 返回链表长度，时间 O(1)
        public int size() {

            return this.size;
        }
    }

    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;    //容量

        private LRUCache(int cap) {
            this.cap = cap;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int val = map.get(key).value;
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            Node x = new Node(key, val);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }
}

class LruCache {
    private final int capacity;
    private final Node[] hashTable;
    private int nodeCount;
    private Node lruHead;
    private Node lruTail;
    private Node eliminateNode;

    LruCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.hashTable = new Node[(int) (capacity / 0.75)];
    }

    public Integer set(int key, int value) {
        int index = hashIndex(key);
        Node node = hashTable[index];
        while (node != null && node.key != key) {
            node = node.hashLink;
        }

        if (node != null) {
            int oldValue = node.value;
            node.value = value;
            touch(node);
            return oldValue;
        }

        if (eliminateNode == null) {
            node = new Node();
        } else {
            node = eliminateNode;
            eliminateNode = null;
        }
        node.key = key;
        node.value = value;
        node.hashLink = hashTable[index];
        hashTable[index] = node;

        if (nodeCount++ == 0) {
            lruHead = node;
            lruTail = node;
        } else {
            node.lruPrev = lruTail;
            lruTail.lruNext = node;
            lruTail = node;
        }

        if (nodeCount > capacity) {
            eliminate();
        }

        return null;
    }

    public Integer get(int key) {
        int index = hashIndex(key);
        Node node = hashTable[index];
        while (node != null && node.key != key) {
            node = node.hashLink;
        }
        if (node == null) {
            return null;
        }

        touch(node);

        return node.value;
    }

    private void touch(Node node) {
        if (node.lruNext == null) {
            return;
        }

        if (node.lruPrev == null) {
            lruHead = node.lruNext;
            lruHead.lruPrev = null;
        } else {
            node.lruPrev.lruNext = node.lruNext;
            node.lruNext.lruPrev = node.lruPrev;
        }
        node.lruNext = null;
        node.lruPrev = lruTail;
        lruTail.lruNext = node;
        lruTail = node;
    }

    private void eliminate() {
        Node node = lruHead;
        if (node == null) {
            return;
        }
        lruHead = node.lruNext;
        lruHead.lruPrev = null;
        node.lruNext = null;

        int index = hashIndex(node.key);
        Node curr = hashTable[index];
        Node last = null;
        while (curr != null && curr != node) {
            last = curr;
            curr = curr.hashLink;
        }

        if (last == null) {
            hashTable[index] = node.hashLink;
        } else {
            last.hashLink = node.hashLink;
        }

        node.hashLink = null;
        eliminateNode = node;
        nodeCount--;
    }

    private int hashIndex(int key) {
        return (key < 0 ? (key == Integer.MIN_VALUE ? 0 : -key) : key) % hashTable.length;
    }

    static class Node {
        int key;
        int value;
        Node hashLink;
        Node lruPrev;
        Node lruNext;
    }
}