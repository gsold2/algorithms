package binary_tree;

public class Node<T> {

    private final T value;
    private final Node<T> left;
    private final Node<T> right;

    public Node(T value) {
        this(value, null, null);
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }
}
