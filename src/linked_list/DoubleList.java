package linked_list;

public class DoubleList<T> {
    int length = 0;
    Node<T> tail;
    Node<T> head;

    public DoubleList() {
    }

    public int size() {
        return length;
    }

    public void insertAt(T t, int index) {
        checkBoundaries(index);
        if (index == length) {
            append(t);
        } else if (index == 0) {
            prepend(t);
        } else {
            Node<T> current = getCurrent(index);
            Node<T> previous = current.getPrev();
            Node<T> node = new Node<>(t);
            node.setNext(current);
            current.setPrev(node);
            node.setPrev(previous);
            previous.setNext(node);
            length++;
        }
    }

    public T remove(T t) {
        Node<T> pointer = head;
        for (int i = 0; i < length; i++) {
            if (pointer.getValue().equals(t)) {
                return removeAt(i);
            }
            pointer = pointer.getNext();
        }
        return null;
    }

    public T removeAt(int index) {
        if (index < 0) {
            throw new RuntimeException("index=" + index + " < 0");
        } else if (index > length - 1) {
            throw new RuntimeException("index=" + index + " > " + (length - 1));
        }
        T value;
        if (index == length - 1) {
            value = tail.getValue();
            Node<T> previous = tail.getPrev();
            previous.setNext(null);
            tail = previous;
        } else if (index == 0) {
            value = head.getValue();
            Node<T> next = head.getNext();
            next.setPrev(null);
            head = next;
        } else {
            Node<T> current = getCurrent(index);
            value = current.getValue();
            Node<T> previous = current.getPrev();
            Node<T> next = current.getNext();
            previous.setNext(next);
            next.setPrev(previous);
        }
        length--;
        return value;
    }

    public void append(T t) {
        Node<T> node = new Node<>(t);
        if (length == 0 & tail == null & head == null) {
            tail = head = node;
        } else if (tail != null) {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        length++;
    }

    public void prepend(T t) {
        Node<T> node = new Node<>(t);
        if (length == 0 & tail == null & head == null) {
            tail = head = node;
        } else if (head != null) {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        length++;
    }

    public T get(int index) {
        return getCurrent(index).getValue();
    }

    private Node<T> getCurrent(int index) {
        Node<T> pointer;
        checkBoundaries(index);
        if (index <= length / 2) {
            pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.getNext();
            }
        } else {
            pointer = tail;
            for (int i = length - 1; i > index; i--) {
                pointer = pointer.getPrev();
            }
        }
        return pointer;
    }

    private void checkBoundaries(int index) {
        if (index < 0) {
            throw new RuntimeException("index=" + index + " < 0");
        } else if (index > length) {
            throw new RuntimeException("index=" + index + " > " + length);
        }
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
