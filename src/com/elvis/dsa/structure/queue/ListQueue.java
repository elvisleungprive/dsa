package com.elvis.dsa.structure.queue;

import com.elvis.dsa.structure.element.ListNode;

public class ListQueue<E> implements Queue<E> {
    private ListNode<E> front;
    private ListNode<E> rear;
    private int size;

    public ListQueue() {
        this.size = 0;
    }

    @Override
    public void enqueue(E element) {
        ListNode<E> node = new ListNode<>(element);

        if (front != null && rear != null) {
            rear.next = node;
            rear = node;
            size++;
        } else {
            front = node;
            rear = node;
            size = 1;
        }
    }

    @Override
    public ListNode<E> dequeue() {
        if (size == 0 || front == null || rear == null)
            throw new RuntimeException("Can not dequeue an empty queue");
        if (front == rear) {
            // equal reference
            ListNode<E> tmp = front;
            front = null;
            rear = null;
            size = 0;
            return tmp;
        } else {
            ListNode<E> tmp = front;
            front = front.next;
            size--;
            return tmp;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public ListNode<E> peek() {
        return front;
    }

    @Override
    public int length() {
        return size;
    }
}
