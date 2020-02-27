package com.elvis.dsa.structure.element;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListNodeTest {

    @Test
    void isNullWithNullValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>(null);
        Assert.assertTrue(node.isNull());
    }

    @Test
    void isNullWithSomeValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>(Mockito.anyString());
        Assert.assertFalse(node.isNull());
    }

    @Test
    void hasNextWithNullValueOnCreationTest() {
        ListNode<Object> node = new ListNode<>(null);
        Assert.assertFalse(node.hasNext());
    }

    @Test
    void hasNextWithSomeValueOnCreationTest() {
        ListNode<String> node = new ListNode<>(Mockito.anyObject());
        Assert.assertFalse(node.hasNext());
    }

    @Test
    void hasNextWithNextNodeTest() {
        ListNode<String> node = new ListNode<>(Mockito.anyString());
        node.next = new ListNode<>(Mockito.anyString());
        Assert.assertTrue(node.hasNext());
    }
}
