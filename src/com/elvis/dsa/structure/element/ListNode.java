package com.elvis.dsa.structure.element;

public class ListNode<E> extends Node<E> {
    public ListNode<E> next;

    public ListNode(E value) {
        super(value);
    }

    public boolean hasNext() {
        return next != null;
    }
}
