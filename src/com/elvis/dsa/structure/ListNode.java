package com.elvis.dsa.structure;

public class ListNode<E> extends Node<E> {
    public E next;

    public ListNode(E value) {
        super(value);
    }

    public boolean hasNext() {
        return next != null;
    }
}
