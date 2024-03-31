package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    private final List<T> heap = new ArrayList<>();

    @SafeVarargs
    public Heap(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public void add(T value) {
        heap.add(value);
        bubbleUp(heap.size());
    }

    public void remove(int index) {
        int indexOfLastElement = heap.size();
        if (index < 0 || index > indexOfLastElement)
            throw new ArrayIndexOutOfBoundsException("index < 0 || index > heap.size()");
        setValueByIndex(index, getValueByIndex(indexOfLastElement));
        removeValueByIndex(indexOfLastElement);
        bubbleDown(index);
    }

    public List<T> getAsList() {
        return heap;
    }

    public void printHeap() {
        StringBuilder stringBuilder = new StringBuilder();
        int indexOfLastElement = heap.size();
        for (int i = 1; i <= indexOfLastElement; i++) {
            String index = "(" + (i + 1) + ")";
            stringBuilder.append(i != indexOfLastElement ? index + getValueByIndex(i) + ", " : index + getValueByIndex(i));
        }
        System.out.println(stringBuilder);
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - childIndex % 2) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return parentIndex * 2 < heap.size();
    }

    private boolean hasRightChild(int parentIndex) {
        return parentIndex * 2 + 1 < heap.size();
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) > 0 & childIndex <= heap.size();
    }

    private T getLeftChild(int parentIndex) {
        if (!hasLeftChild(parentIndex))
            throw new IllegalArgumentException("Index(" + parentIndex + ") doesn't have Left Child");
        return getValueByIndex(getLeftChildIndex(parentIndex));
    }

    private T getRightChild(int parentIndex) {
        if (!hasRightChild(parentIndex))
            throw new IllegalArgumentException("Index(" + parentIndex + ") doesn't have Right Child");
        return getValueByIndex(getRightChildIndex(parentIndex));
    }

    private T getParent(int childIndex) {
        if (!hasParent(childIndex))
            throw new IllegalArgumentException("Index(" + childIndex + ") doesn't have Parent");
        return getValueByIndex(getParentIndex(childIndex));
    }

    private void bubbleUp(int childIndex) {
        if (hasParent(childIndex)) {
            if (isFirstGreaterThanSecond(getParent(childIndex), getValueByIndex(childIndex))) {
                int parentIndex = getParentIndex(childIndex);
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
                bubbleUp(childIndex);
            }
        }
    }

    private void bubbleDown(int parentIndex) {
        int childIndex = 0;
        if (hasRightChild(parentIndex) && isFirstGreaterThanSecond(getLeftChild(parentIndex), getRightChild(parentIndex))) {
            childIndex = getRightChildIndex(parentIndex);
        } else if (hasLeftChild(parentIndex)) {
            childIndex = getLeftChildIndex(parentIndex);
        }
        if (childIndex != 0 && isFirstGreaterThanSecond(getValueByIndex(parentIndex), getValueByIndex(childIndex))) {
            swap(childIndex, parentIndex);
            bubbleDown(childIndex);
        }
    }

    private void swap(int childIndex, int parentIndex) {
        T temp = getValueByIndex(childIndex);
        setValueByIndex(childIndex, getValueByIndex(parentIndex));
        setValueByIndex(parentIndex, temp);
    }

    private T getValueByIndex(int index) {
        return heap.get(index - 1);
    }

    private void setValueByIndex(int index, T value) {
        heap.set(index - 1, value);
    }

    private void removeValueByIndex(int index) {
        heap.remove(index - 1);
    }

    private boolean isFirstGreaterThanSecond(T first, T second) {
        return first.compareTo(second) > 0;
    }
}
