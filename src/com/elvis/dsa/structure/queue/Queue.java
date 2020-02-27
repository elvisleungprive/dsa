package com.elvis.dsa.structure.queue;

import com.elvis.dsa.structure.element.Node;

/**
 * Specification refers to https://www.programiz.com/java-programming/queue
 */
public interface Queue<E> {
    /**
     * Add element to end of queue. If task is successful, it returns true, else it throws an exception
     */
    void enqueue(E element);

    /**
     * Remove and return element from front of queue. Otherwise, it throws an exception
     */
    Node<E> dequeue();

    /**
     * Check if queue is empty
     */
    boolean isEmpty();

    /**
     * Get the value of the front of queue without removing it
     */
    Node<E> peek();

    /**
     * Get the length of the queue
     */
    int length();
}
