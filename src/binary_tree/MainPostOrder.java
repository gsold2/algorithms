package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class MainPostOrder {

    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<>();
        postOrderWalk(BinaryTree.getRoot(), path);
        path.forEach(System.out::println);
    }

    private static void postOrderWalk(Node<Integer> node, List<Integer> path) {
        if (node != null) {
            if (node.getLeft() != null) postOrderWalk(node.getLeft(), path);
            if (node.getRight() != null) postOrderWalk(node.getRight(), path);
            path.add(node.getValue());
        }
    }
}
