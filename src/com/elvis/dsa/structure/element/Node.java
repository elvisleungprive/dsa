package com.elvis.dsa.structure.element;

public abstract class Node<E> {
    public E value;

    public Node(E value) {
        this.value = value;
    }

    boolean isNull() {
        return value == null;
    }
}
