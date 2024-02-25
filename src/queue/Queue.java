package queue;

public class Queue<T> {
    private int length = 0;

    private Node<T> head = null;
    private Node<T> tail = null;

    public void enqueue(T t) {
        Node<T> node = new Node<>(t);
        if (length > 0) {
            tail.setNext(node);
            tail = node;
            length++;
        } else {
            head = tail = node;
            length++;
        }
    }

    public T dequeue() {
        if (length > 0) {
            length--;
            Node<T> node = head;
            head = head.getNext();
            return node.getValue();
        } else {
            return null;
        }
    }

    public T peek() {
        return tail.getValue();
    }

    @Override
    public String toString() {
        if (length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            Node<T> pointer = head;
            for (int i = 0; i < length; i++) {
                stringBuilder.append("Node = ").append(pointer.getValue()).append("; ");
                pointer = pointer.getNext();
            }
            return stringBuilder.toString();
        } else {
            return null;
        }
    }
}
