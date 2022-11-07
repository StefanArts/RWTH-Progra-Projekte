package de.stefan.progra.projects.sorting;

import java.util.Arrays;

public class SortingAlogrithm {

    public static void main(String[] args) {
        int[] toSort = {12, 63, 23,45, 24,11};
        bubbleSort(toSort);
    }

    public static void bubbleSort(int[] arrayToSort) {

        for(int i = 0; i < arrayToSort.length - 1; i++) {
            for(int j = i; j >= 0; j--) {
                if(arrayToSort[j] < arrayToSort[j + 1]) {
                    int temp = arrayToSort[j + 1];
                    arrayToSort[j + 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
                System.out.println(Arrays.toString(arrayToSort));
            }
        }

    }

    public static void mySort(int[] arrayToSort) {

    }
}
