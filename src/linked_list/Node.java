package linked_list;


public class Node<T> {
    private Node<T> prev;
    private Node<T> next;
    private final T value;

    public Node(T value){
        this(null, null, value);
    }

    public Node(Node<T> prev, Node<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
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

