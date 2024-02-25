package queue;

public class MainQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
            System.out.println("Enqueue Node = " + queue.peek());
            System.out.println(queue);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Dequeue Node = " + queue.dequeue());
            System.out.println(queue);
        }
    }
}
