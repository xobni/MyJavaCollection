package com.scalifir.mycollections;

import org.junit.jupiter.api.Assertions;

class MyLinkedListTest {

    @org.junit.jupiter.api.Test
    void testToArrayConversion() {
        Integer testData[] = {0, 1, 2, 3, 4, 5, 6, 7};
        MyLinkedList<Integer> list = new MyLinkedList(testData);
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));
    }

    @org.junit.jupiter.api.Test
    void testAddToEmptyList() {
        Integer testData[] = {3};
        MyLinkedList<Integer> list = new MyLinkedList();
        list.add(3);
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));
    }

    @org.junit.jupiter.api.Test
    void testGetFromEmptyList() {
        MyLinkedList<Integer> list = new MyLinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveFromEmptyList() {
        MyLinkedList<Integer> list = new MyLinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveFromList() {
        Integer testData[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        MyLinkedList<Integer> list = new MyLinkedList(testData);

        list.remove(3);
        testData = new Integer[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));

        list.remove(11);
        testData = new Integer[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));

        list.remove(0);
        testData = new Integer[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));

        list.remove(8);
        testData = new Integer[]{1, 2, 4, 5, 6, 7, 8, 9, 11};
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(10);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @org.junit.jupiter.api.Test
    void testGetFromList() {
        Integer testData[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        MyLinkedList<Integer> list = new MyLinkedList(testData);
        Assertions.assertEquals(3, list.get(3));
        Assertions.assertEquals(11, list.get(11));
    }

}