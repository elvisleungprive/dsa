package com.elvis.dsa.structure.queue;

import com.elvis.dsa.structure.element.ListNode;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void dequeueEmptyQueue() {
        ListQueue<Integer> queue = new ListQueue<>();
        assertTrue(queue.isEmpty());
        Exception exception = assertThrows(RuntimeException.class, () -> queue.dequeue());
        String expectedMessage = "Can not dequeue an empty queue";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void enqueueAndDequeueNonEmptyQueue() {
        // FIFO
        ListQueue<Integer> queue = new ListQueue<>();
        Integer testInt1 = Mockito.anyInt();
        Integer testInt2 = Mockito.anyInt();
        Integer testInt3 = Mockito.anyInt();

        assertTrue(queue.isEmpty());
        assertSame(0, queue.length());
        assertNull(queue.peek());

        // enqueue 1
        queue.enqueue(testInt1);
        assertEquals(1, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(testInt1, queue.peek().value);

        // enqueue 2
        queue.enqueue(testInt2);
        assertEquals(2, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(testInt1, queue.peek().value);

        // dequeue 1
        ListNode<Integer> actual1 = queue.dequeue();
        assertEquals(testInt1, actual1.value);
        assertEquals(1, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(testInt2, queue.peek().value);

        // enqueue 3
        queue.enqueue(testInt3);
        assertEquals(2, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(testInt2, queue.peek().value);

        // dequeue 2
        ListNode<Integer> actual2 = queue.dequeue();
        assertEquals(testInt1, actual1.value);
        assertEquals(1, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(testInt3, queue.peek().value);

        // dequeue 3
        ListNode<Integer> actual3 = queue.dequeue();
        assertEquals(testInt3, actual3.value);
        assertEquals(0, queue.length());
        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
    }
}
