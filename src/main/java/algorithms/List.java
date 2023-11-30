package algorithms;

public class List {
    Node head;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    /**
     *
     */
    public void revert() {
        if (head != null) {
            Node previous = null;
            Node current = head;
            while (current.next != null) {
                Node temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
            current.next = previous;
            head = current;
        }
    }

    public String toString() {
        StringBuilder allList = new StringBuilder();
        if (head != null) {
            Node current = head;
            while (current != null) {
                allList.append(current.value).append(" | ");
                current = current.next;
            }
        }
        return allList.toString();
    }

    class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {
        List list = new List();

        for (int i = 0; i <= 5; i++ ) {
            list.add(i);
        }

        System.out.println("Прямой:\n" + list);
        list.revert();
        System.out.println("Обратный:\n" + list);

    }
}
