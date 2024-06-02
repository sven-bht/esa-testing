package Aufgabe4;

public class LinkedList {
    Node head;
    int length;

    LinkedList() {
        head = null;
        length = 0;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    current.next = newNode;
                }
                current = current.next;
            }
        }
        length++;
    }

    public int getElement(int index) throws ElementNotPresentException {
        if (index < 0 || index >= length) {
            throw new ElementNotPresentException();
        }
        Node current = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
        }
        return 0;
    }

    public void removeFirst(int data) {
        Node current = head;
        Node previous = null;
        for (int i = 0; i < length; i++) {
            if (current.data == data) {
                length--;
                if (length == 0) {
                    head = null;
                } else if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public int sum() {
        // Diese Methode soll herausgemockt werden
        return 0;
    }

    public int average() {
        int sum = sum();
        return sum / length;
    }

    public String toString() {
        Node current = head;
        StringBuilder listString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            listString.append(current.data).append(" ");
            current = current.next;
        }
        return listString.toString();
    }
}
