package com.edu.practice.usecase;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class U1_LRUImplementation {

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));        // moves 1 to front
        cache.put(3, 30);    // evicts key 2
    }
}

class LRU {

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get (int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }


        remove(node);
        moveToFront(node);
        return  node.value;
    }

    public void put (int key, int value) {

        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lastNodeToRemove = tail.prev;
                remove(lastNodeToRemove);
                map.remove(lastNodeToRemove.key);
            }
            node = new Node(key, value);
            moveToFront(node);
            map.put(key, node);
        }

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }



}

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}