class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertAfterNth(int n, int data) {
        Node temp = head;
        int count = 1;
        while (temp != null && count < n) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeNthFromEnd(int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy, second = dummy;

        for (int i = 0; i <= n; i++) {
            if (first == null) return;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        head = dummy.next;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main04 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        System.out.print("Original List: ");
        ll.printList();

        ll.insertAfterNth(3, 5);
        System.out.print("After inserting 5 after 3rd element: ");
        ll.printList();

        ll.insertAtEnd(5);
        System.out.print("After inserting 5 at end: ");
        ll.printList();

        ll.removeNthFromEnd(2);
        System.out.print("After removing 2nd element from end: ");
        ll.printList();
    }
}
