package week02.hash;

import java.util.HashMap;

/**
 * leetcode: https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node() {
        }
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final HashMap<Integer, Node> h;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        h = new HashMap<>();
    }

    public int get(int key) {
        Node node = h.get(key);
        if (node == null) return -1;
        _remove(node);
        _insert(head, node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = h.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            h.put(key, node);
            _insert(head, node);
            if (h.size() > capacity) {
                // 注意：要先删索引
                h.remove(tail.pre.key);
                _remove(tail.pre);
            }
        } else {
            node.value = value;
            _remove(node);
            _insert(head, node);
        }
    }

    private void _remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void _insert(Node p, Node node) {
        p.next.pre = node;
        node.next = p.next;
        p.next = node;
        node.pre = p;
    }
}
