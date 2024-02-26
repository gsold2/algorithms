package linked_list;

public class MainDoubleList {
    public static void main(String[] args) {
        DoubleList<Integer> doubleList = new DoubleList<>();
        for (int i = 3; i <= 5; i++) {
            doubleList.append(i);
        }
        System.out.println(doubleList);
        for (int i = 2; i >= 1; i--) {
            doubleList.prepend(i);
        }
        System.out.println(doubleList);
        doubleList.insertAt(0, 0);
        System.out.println(doubleList);
        doubleList.insertAt(7, 6);
        System.out.println(doubleList);
        doubleList.insertAt(6, 6);
        System.out.println(doubleList);
        System.out.println("get(0)=" + doubleList.get(0));
        System.out.println("get(5)=" + doubleList.get(5));
        System.out.println("get(7)=" + doubleList.get(7));
        System.out.println(doubleList);
        System.out.println("removeAt(7)=" + doubleList.removeAt(7));
        System.out.println(doubleList);
        System.out.println("removeAt(0)=" + doubleList.removeAt(0));
        System.out.println(doubleList);
        System.out.println("removeAt(1)=" + doubleList.removeAt(1));
        System.out.println(doubleList);
        System.out.println("remove(1)=" + doubleList.remove(1));
        System.out.println(doubleList);
        System.out.println("remove(6)=" + doubleList.remove(6));
        System.out.println(doubleList);
        System.out.println("remove(4)=" + doubleList.remove(4));
        System.out.println(doubleList);
        System.out.println("size()=" + doubleList.size());
    }
}
