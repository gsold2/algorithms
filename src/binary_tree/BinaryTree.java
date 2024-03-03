package binary_tree;

public class BinaryTree {
    static Node<Integer> getRoot(){
        Node<Integer> V = new Node<>(5);
        Node<Integer> IV = new Node<>(4);
        Node<Integer> XVIII = new Node<>(18);
        Node<Integer> XXI = new Node<>(21);
        Node<Integer> XXIII = new Node<>(23, V, IV);
        Node<Integer> III = new Node<>(3, XVIII, XXI);
        return new Node<>(7, XXIII, III);
    }
}
