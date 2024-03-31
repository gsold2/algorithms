package heap;

import java.util.Arrays;

public class MainHeap {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(2, 4, 8, 9, 7, 10, 12, 15, 20, 13);
        heap.printHeap();
        heap.add(2);
        if (Arrays.asList(2, 2, 8, 9, 4, 10, 12, 15, 20, 13, 7).equals(heap.getAsList())) {
            System.out.println("add() is correct");
        } else {
            System.out.println("add() is not correct");
        }
        heap.printHeap();
        heap.remove(1);
        if (Arrays.asList(2, 4, 8, 9, 7, 10, 12, 15, 20, 13).equals(heap.getAsList())) {
            System.out.println("remove() is correct");
        } else {
            System.out.println("remove() is not correct");
        }
        heap.printHeap();
    }
}
