public class LL_19 {
    public class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private node head;
    private node tail;
    private int size;

    public void insertAtHead(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public node reverseKGroup(node head, int k) {
        int len = 0;
        node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (len < k) {
            return head;
        }
        node prev = null;
        node curr = head;
        for (int i = 0; i < k; i++) {
            node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        node recursionHead = reverseKGroup(curr, k);
        head.next = recursionHead;
        return prev;
    }
    public static void main(String[] args) {
        LL_19 myList = new LL_19();
        myList.insertAtHead(5);
        myList.insertAtHead(4);
        myList.insertAtHead(3);
        myList.insertAtHead(2);
        myList.insertAtHead(1);
        myList.display();
        myList.head = myList.reverseKGroup(myList.head, 2);
        myList.display();
    }
}