package com.thaind.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorSample {

    public static void main(String[] args) {
        // initialize
        Vector<Integer> vector = new Vector<>();
        Integer[] arr = {1, 5, 6, 4, 5};
        // gen items
        vector.addAll(Arrays.asList(arr));
        // print all
        System.out.println(vector);
        // remove item at index 1
        vector.remove(1);
        // print one by one
        for (int index : vector) {
            System.out.print(index + "\t");
        }
        System.out.println("");
        System.out.println(findMinInteger(vector));
        sortVector(vector);
        printAllItem(vector);
    }

    private static void addNotDuplicate(int item, Vector<Integer> vector) {
        if (!vector.contains(item)) {
            vector.add(item);
        } else {
            System.err.println("This item has been in the vector before!");
        }
    }

    private static boolean deleteAtSpecifiedIndex(int index, Vector<Integer> vector) {
        boolean result = true;
        if (index < 0 || index > vector.size()) {
            result = false;
        }
        if (result) {
            vector.remove(index);
        }
        return result;
    }

    private static int findMinInteger(Vector<Integer> vector) {
        return Collections.min(vector);
    }

    private static void sortVector(Vector<Integer> vector) {
        Collections.sort(vector);
    }

    private static void printAllItem(Vector vector) {
        for (Object item : vector) {
            System.out.print(item + "\t");
        }
    }
}
