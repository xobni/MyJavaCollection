package com.scalifir.mycollections;

public class MyArrayList<E> {
    private int size, reserved;
    private E items[];

    public MyArrayList() {
        size = 0;
        reserved = 8;
        items = (E[]) new Object[reserved];
    }

    public MyArrayList(E items[]) {
        this();
        for (E item : items) {
            add(item);
        }
    }

    public void add(E item) {
        add(size - 1, item);
    }

    public void add(int position, E item) {
        provideSize();
        items[size] = item;
        size++;
    }

    public void remove(int position) {
        checkBounds(position);
        System.arraycopy(items, position + 1, items, position, size - position - 1);
        size--;
    }

    public E get(int position) {
        checkBounds(position);
        return items[position];
    }

    public int size() {
        return size;
    }

    public E[] toArray(E[] array) {
        E newArray[] = (E[]) new Object[size];
        System.arraycopy(items, 0, newArray, 0, size);
        return newArray;
    }

    private void checkBounds(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void provideSize() {
        if (size >= items.length) {
            E newArray[] = (E[]) new Object[size + 8];
            System.arraycopy(items, 0, newArray, 0, size);
            items = newArray;
        }

    }

}

