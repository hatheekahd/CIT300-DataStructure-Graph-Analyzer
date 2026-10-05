package app;

import linkedlist.LinkedListOperations;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("--- Linked List Operations ---");
        list.display();

        System.out.println("Search 30: index " + list.search(30));
        System.out.println("Search 99 (not present): index " + list.search(99));

        System.out.println("Delete 20: " + list.delete(20));
        list.display();

        System.out.println("Delete 99 (not present): " + list.delete(99));

        System.out.println("Size: " + list.getSize());
    }
}