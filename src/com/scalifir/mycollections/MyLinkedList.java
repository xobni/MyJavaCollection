package com.scalifir.mycollections;

public class MyLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = new Node<E>();
        tail = new Node<E>();
        head.next = tail;
        tail.prev = head;
    }

    public MyLinkedList(E items[]) {
        this();
        for (E item : items) {
            add(item);
        }
    }

    public void add(E item) {
        add(size - 1, item);
    }

    public void add(int position, E item) {
        Node<E> node;
        if (position == -1) {
            node = head;
        } else {
            node = getNode(position);
        }
        node.next.prev = new Node<>(node, item, node.next);
        node.next = node.next.prev;
        size++;
    }

    public void remove(int position) {
        Node<E> node = getNode(position);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public E get(int position) {
        return getNode(position).item;
    }

    public int size() {
        return size;
    }

    public E[] toArray(E[] array) {
        Node<E> node = head.next;
        for (int i = 0; i < array.length && i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    private Node<E> getNode(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node;
        if (position < size / 2) {
            node = head.next;
            while (position > 0) {
                node = node.next;
                position--;
            }
        } else {
            node = tail.prev;
            while (position < size - 1) {
                node = node.prev;
                position++;
            }
        }

        return node;
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node() {
        }

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
