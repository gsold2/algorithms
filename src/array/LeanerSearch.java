package array;

public class LeanerSearch {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(leanerSearch(array, 0));
        System.out.println(leanerSearch(array, 9));
        System.out.println(leanerSearch(array, 5));
        System.out.println(leanerSearch(array, -1));
        System.out.println(leanerSearch(array, 10));
    }

    private static boolean leanerSearch(int[] array, int searchNumber) {
        for (int j : array) {
            if (j == searchNumber) {
                return true;
            }
        }
        return false;
    }
}