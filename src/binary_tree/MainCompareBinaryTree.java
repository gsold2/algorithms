package binary_tree;

public class MainCompareBinaryTree {
    public static void main(String[] args) {
        Node<Integer> rootOfBinaryTree = BinaryTree.getRootOfBinaryTree();
        Node<Integer> rootOfOverBinaryTree = BinaryTree.getRootOfOverBinaryTree();
        System.out.println(compareInOrderWalk(rootOfBinaryTree, rootOfOverBinaryTree));
    }

    private static boolean compareInOrderWalk(Node<Integer> firstNode, Node<Integer> secondNode) {
        if (firstNode == null & secondNode == null) {
            return true;
        } else if (firstNode == null | secondNode == null) {
            return false;
        } else if (!firstNode.getValue().equals(secondNode.getValue())) {
            return false;
        }
        return compareInOrderWalk(firstNode.getLeft(), secondNode.getLeft()) & compareInOrderWalk(firstNode.getRight(), secondNode.getRight());
    }
}