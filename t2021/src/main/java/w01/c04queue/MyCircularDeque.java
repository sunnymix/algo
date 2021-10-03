package w01.c04queue;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque q = new MyCircularDeque(3);
        System.out.println(q.insertLast(1));
        System.out.println(q.insertLast(2));
        System.out.println(q.insertFront(3));
        System.out.println(q.insertFront(4));
        System.out.println(q.getRear());
        System.out.println(q.isFull());
        System.out.println(q.deleteLast());
        System.out.println(q.insertFront(4));
        System.out.println(q.getFront());
        q.print();
        Print.array(q.a);
    }

    /**
     * 存储元素的数组
     */
    int[] a;

    /**
     * 队列的容量
     */
    int capacity;

    /**
     * 队头：指向第1个元素
     */
    int front;

    /**
     * 队尾：指向末尾元素的下个位置
     */
    int rear;

    private int _getPreIndex(int i) {
        return (i - 1 + a.length) % a.length;
    }

    private int _getNextIndex(int i) {
        return (i + 1) % a.length;
    }

    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        if (!isEmpty()) {
            int head = front;
            while (head != rear) {
                s.append(a[head]);
                s.append(",");
                head = _getNextIndex(head);
            }
        }
        s.append("]");
        System.out.println(s);
    }

    public MyCircularDeque(int k) {
        capacity = k;
        // 留出1个单位作为队尾位置，用于区分队列为空与队列已满的判断条件
        a = new int[k + 1];
        // 初始情况，队头等于队尾
        front = rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = _getPreIndex(front);
        a[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        a[rear] = value;
        rear = _getNextIndex(rear);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = _getNextIndex(front);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = _getPreIndex(rear);
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return a[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int rearValIndex = _getPreIndex(this.rear);
        return a[rearValIndex];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % a.length == front;
    }
}
