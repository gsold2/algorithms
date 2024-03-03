package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class MainPreOrder {

    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<>();
        preOrderWalk(BinaryTree.getRoot(), path);
        path.forEach(System.out::println);
    }

    private static void preOrderWalk(Node<Integer> node, List<Integer> path) {
        if (node != null) {
            path.add(node.getValue());
            if (node.getLeft() != null) preOrderWalk(node.getLeft(), path);
            if (node.getRight() != null) preOrderWalk(node.getRight(), path);
        }
    }
}
