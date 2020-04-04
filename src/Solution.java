public class Solution {
    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front, rear;
    }

    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null) {
            q.front = temp;
        } else {
            q.rear.link = temp;
        }
        q.rear = temp;
        q.rear.link = q.front;
    }

    static int deQueue(Queue q) {
        if (q.front == null) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        } else {
            int value;
            if (q.front == q.rear) {
                value = q.front.data;
                q.front = null;
                q.rear = null;
            } else {
                value = q.front.data;
                q.front = q.front.link;
                q.rear.link = q.front;
            }
            return value;
        }
    }

    public static void displayQueue(Queue q) {
        Node temp = q.front;
        while (temp.link != q.front) {
            System.out.printf("%d\n", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d\n", temp.data);
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;

        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, -6);
        System.out.println("Queue : ");
        displayQueue(q);

        System.out.printf("Delete = %d\n", deQueue(q));
        System.out.printf("Delete = %d\n", deQueue(q));
        System.out.println("Queue : ");
        displayQueue(q);

        enQueue(q, 8);
        enQueue(q, 20);
        System.out.println("Queue : ");
        displayQueue(q);
    }
}
