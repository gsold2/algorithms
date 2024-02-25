package quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int index = lowIndex - 1;
        for (int i = lowIndex; i < pivot; i++) {
            if (array[i] <= pivot) {
                index++;
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        index++;
        array[highIndex] = array[index];
        array[index] = pivot;
        return index;
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivotIndex = partition(array, lowIndex, highIndex);
        quickSort(array, lowIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, highIndex);
    }
}
