package com.elvis.dsa.structure.queue;

import com.elvis.dsa.structure.element.ListNode;

public interface IQueue<E> {
    /**
     * Add element to end of queue
     */
    void enqueue(E element);

    /**
     * Remove and return element from front of queue. Otherwise, it throws an exception
     */
    ListNode<E> dequeue();

    /**
     * Check if queue is empty
     */
    boolean isEmpty();

    /**
     * Get the value of the front of queue without removing it
     */
    ListNode<E> peek();

    /**
     * Get the length of the queue
     */
    int length();
}
