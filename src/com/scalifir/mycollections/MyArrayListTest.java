package com.scalifir.mycollections;

import org.junit.jupiter.api.Assertions;

public class MyArrayListTest {

    @org.junit.jupiter.api.Test
    void testToArrayConversion() {
        Integer testData[] = {0, 1, 2, 3, 4, 5, 6, 7};
        MyArrayList<Integer> list = new MyArrayList(testData);
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));
    }

    @org.junit.jupiter.api.Test
    void testAddToEmptyList() {
        Integer testData[] = {3};
        MyArrayList<Integer> list = new MyArrayList();
        list.add(3);
        Assertions.assertArrayEquals(testData, list.toArray(new Integer[list.size()]));
    }

    @org.junit.jupiter.api.Test
    void testGetFromEmptyList() {
        MyArrayList<Integer> list = new MyArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveFromEmptyList() {
        MyArrayList<Integer> list = new MyArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveFromList() {
        Integer testData[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        MyArrayList<Integer> list = new MyArrayList(testData);

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
        MyArrayList<Integer> list = new MyArrayList(testData);
        Assertions.assertEquals(3, list.get(3));
        Assertions.assertEquals(11, list.get(11));
    }


}
