public class LL_18 {
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

    public node partition(int x) {
        node lesserHead = null;
        node lesserTail = null;
        node greaterHead = null;
        node greaterTail = null;

        node temp = head;

        while (temp != null) {
            node nextNode = temp.next;
            temp.next = null;

            if (temp.data < x) {
                if (lesserHead == null) {
                    lesserHead = lesserTail = temp;
                } else {
                    lesserTail.next = temp;
                    lesserTail = temp;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = greaterTail = temp;
                } else {
                    greaterTail.next = temp;
                    greaterTail = temp;
                }
            }
            temp = nextNode;
        }
        if (lesserHead == null) {
            head = greaterHead;
            tail = greaterTail;
        } else {
            lesserTail.next = greaterHead;
            head = lesserHead;
            tail = (greaterTail != null) ? greaterTail : lesserTail;
        }
        return head;
    }
    public static void main(String[] args) {
        LL_18 myList = new LL_18();
        myList.insertAtHead(2);
        myList.insertAtHead(5);
        myList.insertAtHead(2);
        myList.insertAtHead(3);
        myList.insertAtHead(4);
        myList.insertAtHead(1);
        myList.display();
        myList.partition(3);
        myList.display();
    }
}
