package com.elvis.dsa.structure;

public abstract class Node<E> {
    public E value;

    public Node(E value) {
        this.value = value;
    }

    boolean isNull() {
        return value == null;
    }
}
