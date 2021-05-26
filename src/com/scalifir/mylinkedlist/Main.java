package com.scalifir.mylinkedlist;

public class Main {

    public static void main(String[] args) {
        Integer testData []= {0,1,2,3,4,5,6,7};
        MyLinkedList<Integer> list = new MyLinkedList (testData);
        printList(list);
        list.remove(7);
        printList(list);

    }

    private static void printList(MyLinkedList list) {
        for (int i = 0; i<list.size(); i++) {
            System.out.println("List element number " + i + " is " + list.get(i));
        }

    }
}
