package array;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2, 1};
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int firstInt = array[j];
                int secondInt = array[j + 1];
                if (firstInt > secondInt) {
                    array[j] = array[j + 1];
                    array[j + 1] = firstInt;
                }
                System.out.println(Arrays.toString(array));
                System.out.println(i+" - "+j);
            }
        }
    }
}
