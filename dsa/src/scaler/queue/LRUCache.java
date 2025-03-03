package scaler.queue;

import scaler.linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }

    Node head, tail;
    int capacity;
    Map<Integer, Node> mp;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.mp = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        return 0;
    }

    public void set(int key, int value) {

    }


}
