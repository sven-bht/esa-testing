package Aufgabe1_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList list = new LinkedList();

    @Test
    void addOne() {
        assertEquals(list.length, 0);
        assertNull(list.head);

        list.addBack(1);

        assertEquals(list.head.data, 1);
        assertEquals(list.length, 1);
        assertNull(list.head.next);
    }

    @Test
    void addNegativeOne() {
        assertEquals(list.length, 0);
        assertNull(list.head);

        list.addBack(-1);

        assertEquals(list.head.data, -1);
        assertEquals(list.length, 1);
        assertNull(list.head.next);
    }

    @Test
    void addTen() {
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.addBack(4);
        list.addBack(5);
        list.addBack(6);
        list.addBack(7);
        list.addBack(8);
        list.addBack(9);
        list.addBack(10);
        assertEquals(list.length, 10);
        assertEquals(list.toString(), "1 2 3 4 5 6 7 8 9 10 ");
    }

    @Test
    void addOneRemoveOne() {
        list.addBack(1);
        list.removeFirst(1);
        assertNull(list.head);
        assertEquals(list.length, 0);
    }

    @Test
    void addOneRemoveOneAddOne() {
        list.addBack(1);
        list.removeFirst(1);
        list.addBack(1);
        assertEquals(list.length, 1);
        assertEquals(list.head.data, 1);
    }

    @Test
    void addFiveRemoveThree() {
        list.addBack(5);
        list.addBack(6);
        list.addBack(7);
        list.addBack(8);
        list.addBack(9);
        list.removeFirst(5);
        list.removeFirst(6);
        list.removeFirst(9);
        assertEquals(list.length, 2);
        assertEquals(list.toString(), "7 8 ");
    }

    @Test
    void removeOne() {
        list.removeFirst(1);
        assertEquals(list.length, 0);
        assertNull(list.head);
    }

    @Test
    void addOneRemoveAnother() {
        list.addBack(1);
        list.removeFirst(2);
        assertEquals(list.length, 1);
        assertEquals(list.head.data, 1);
        assertNull(list.head.next);
    }

    @Test
    void addTwoRemoveOneSame() {
        list.addBack(1);
        list.addBack(1);
        assertEquals(list.length, 2);
        list.removeFirst(1);
        assertEquals(list.head.data, 1);
        assertEquals(list.length, 1);
        assertNull(list.head.next);
    }

    @Test
    void getElementWithOneElement() {
        list.addBack(1);
        int element = list.getElement(0);
        assertEquals(element, 1);
    }

    @Test
    void getElementWithTwoElements() {
        list.addBack(1);
        list.addBack(2);
        int element1 = list.getElement(0);
        assertEquals(element1, 1);
        int element2 = list.getElement(1);
        assertEquals(element2, 2);
    }

    @Test
    void getElementWithThreeElements() {
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        int element1 = list.getElement(0);
        assertEquals(element1, 1);
        int element2 = list.getElement(1);
        assertEquals(element2, 2);
        int element3 = list.getElement(2);
        assertEquals(element3, 3);
    }

    @Test
    void getElementWithEmptyList() {
        assertThrows(
                ElementNotPresentException.class,
                () ->list.getElement(0)
        );
    }

    @Test
    void getElementOutOfBounds() {
        list.addBack(1);
        list.addBack(2);
        assertThrows(
                ElementNotPresentException.class,
                () -> list.getElement(2)
        );
    }

    @Test
    void getElementWithNegativeIndex() {
        list.addBack(1);
        list.addBack(2);
        assertThrows(
                ElementNotPresentException.class,
                () -> list.getElement(-1)
        );
    }
}