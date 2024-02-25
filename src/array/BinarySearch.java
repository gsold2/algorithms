package array;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        search(array, -1);
        search(array, 0);
        search(array, 5);
        search(array, 9);
        search(array, 10);
    }

    private static void search(int[] array, int search) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        int middleIndex = 0;
        while (minIndex < maxIndex) {
            middleIndex = ((maxIndex - minIndex) / 2) + minIndex;
            if (array[middleIndex] == search) {
                System.out.println("[" + middleIndex + "] = " + array[middleIndex]);
                break;
            } else if (array[middleIndex] < search) {
                minIndex = middleIndex + 1;
            } else {
                maxIndex = middleIndex;
            }
            System.out.println(Arrays.toString(Arrays.copyOfRange(array, minIndex, maxIndex + 1)));
        }
        if (array[middleIndex] != search) {
            System.out.println("Nothing was found");
        }
        System.out.println("-------------------");
    }
}
