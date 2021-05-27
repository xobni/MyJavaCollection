package com.scalifir.mycollections;

public class Main {

    public static void main(String[] args) {

    }

    private static void printLinkedList(MyLinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List element number " + i + " is " + list.get(i));
        }

    }

    private static void printArrayList(MyArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List element number " + i + " is " + list.get(i));
        }

    }
}
