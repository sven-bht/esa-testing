package Aufgabe4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LinkedListTest {
    LinkedList list = new LinkedList();

    @Test
    void testAverage() {
        LinkedList linkedListSpy = spy(new LinkedList());
        doReturn(15).when(linkedListSpy).sum();

        linkedListSpy.addBack(1);
        linkedListSpy.addBack(2);
        linkedListSpy.addBack(3);
        linkedListSpy.addBack(4);
        linkedListSpy.addBack(5);

        int average = linkedListSpy.average();
        assertEquals(3, average);
    }
}