package com.edu.practice.usecase;

import java.util.HashMap;
import java.util.Map;

public class LRUPractice {

    public static void main(String[] args) {
        LRU1 cache = new LRU1(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));        // moves 1 to front
        cache.put(3, 30);    // evicts key 2
    }

}

class LRU1 {

    private final int capacity;
    private final Map<Integer, Node1> map;
    private final Node1 head;
    private final Node1 tail;

    LRU1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node1(0,0);
        this.tail = new Node1(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        Node1 node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        moveToFront(node);
        return node.value;
    }

    public void put (int key, int value) {
        Node1 node = map.get(key);
        if (node!=null){
            remove(node);
            moveToFront(node);
            node.value = value;
            map.put(key, node);
        } else {
            if (map.size()==capacity) {
                Node1 lastNodeToRemove = tail.prev;
                remove(lastNodeToRemove);
                map.remove(key);
            }
            node = new Node1(key,value);
            moveToFront(node);
            map.put(key, node);
        }
    }

    private void remove(Node1 node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToFront(Node1 node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

class Node1{
    int key, value;
    Node1 prev, next;

    public Node1(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
