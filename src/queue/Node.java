package queue;

public class Node<T> {
    private Node<T> next;
    private final T value;

    public Node(T t) {
        this(null, t);
    }

    public Node(Node<T> next, T t) {
        this.next = next;
        this.value = t;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }
}
