package binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MainBFSBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = BinaryTree.getRootOfBinaryTree();
        bfs(root);
    }

    private static void bfs(Node<Integer> start) {
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<Integer> currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            System.out.print(currentNode.getValue() + " ");
            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
    }
}
