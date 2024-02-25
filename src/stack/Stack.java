package stack;

import queue.Node;

public class Stack<T> {
    private int length = 0;

    private Node<T> head = null;

    public void push(T t) {
        Node<T> node = new Node<>(t);
        if (length > 0) {
            node.setNext(head);
            head = node;
            length++;
        } else {
            head = node;
            length++;
        }
    }

    public T pop() {
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
        return head.getValue();
    }

    @Override
    public String toString() {
        if (length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            Node<T> nodePointer = head;
            for (int i = 0; i < length; i++) {
                stringBuilder.append("Node = ").append(nodePointer.getValue()).append("; ");
                nodePointer = nodePointer.getNext();
            }
            return stringBuilder.toString();
        } else {
            return null;
        }
    }
}
