package com.elvis.dsa.structure.element;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    void isNullWithNullValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>(null);
        Assert.assertTrue(node.isNull());
    }

    @Test
    void isNullWithSomeValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>("some thing");
        Assert.assertFalse(node.isNull());
    }

    @Test
    void hasNextWithNullValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>(null);
        Assert.assertFalse(node.hasNext());
    }

    @Test
    void hasNextWithSomeValueOnCreationTest() {
        ListNode<String> node = new ListNode<>("some thing");
        Assert.assertFalse(node.hasNext());
    }

    @Test
    void hasNextWithNextNodeTest() {
        ListNode<String> node = new ListNode<>("some thing");
        node.next = "next";
        Assert.assertTrue(node.hasNext());
    }
}