package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class MainInOrder {

    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<>();
        inOrderWalk(BinaryTree.getRoot(), path);
        path.forEach(System.out::println);
    }

    private static void inOrderWalk(Node<Integer> node, List<Integer> path) {
        if (node != null) {
            if (node.getLeft() != null) inOrderWalk(node.getLeft(), path);
            path.add(node.getValue());
            if (node.getRight() != null) inOrderWalk(node.getRight(), path);
        }
    }
}
