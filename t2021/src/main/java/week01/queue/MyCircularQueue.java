package week01.queue;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/design-circular-queue/
 */
public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        Print.line(q.enQueue(1));
        Print.line(q.enQueue(2));
        Print.line(q.enQueue(3));
        Print.line(q.enQueue(4));
        Print.line(q.Rear());
        Print.line(q.isFull());
        Print.line(q.deQueue());
        Print.line(q.enQueue(4));
        Print.line(q.Rear());
        Print.line(q.Front());
        Print.line(q.toString());
    }

    /**
     * 存储元素的数组
     */
    private final int[] a;

    /**
     * 队列的容量
     */
    private int capacity;

    /**
     * 队头：指向第1个元素
     */
    private int front;

    /**
     * 队尾：指向末尾元素的下个位置
     */
    private int rear;

    private int _getPreIndex(int i) {
        return (i - 1 + a.length) % a.length;
    }

    private int _getNextIndex(int i) {
        return (i + 1) % a.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        if (!isEmpty()) {
            int head = front;
            while (head != rear) {
                s.append(a[head]);
                s.append(",");
                head = _getNextIndex(head);
            }
            // 删除末尾多余的逗号（,）
            if (s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
            }
        }
        s.append("]");
        return s.toString();
    }

    public MyCircularQueue(int k) {
        a = new int[k + 1];
        capacity = k;
        front = rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        a[rear] = value;
        rear = _getNextIndex(rear);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = _getNextIndex(front);
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return a[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return a[_getPreIndex(rear)];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return ((rear + 1) % a.length) == front;
    }
}
