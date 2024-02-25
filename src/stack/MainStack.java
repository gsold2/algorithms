package stack;

public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println("Push Node = " + stack.peek());
            System.out.println(stack);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Pop Node = " + stack.pop());
            System.out.println(stack);
        }
    }
}
