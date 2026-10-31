public class LL_21 {
    public class node {
        int data;
        node next;
        node prev;
        node child;

        node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.child = null;
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
            head.prev = newNode;
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

    public node flatten() {
        if (head == null) {
            return head;
        }
        node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
            } else {
                node temp = p.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = p.next;
                if (p.next != null) {
                    p.next.prev = temp;
                }
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        LL_21 myList = new LL_21();

        myList.insertAtHead(5);
        myList.insertAtHead(4);
        myList.insertAtHead(3);
        myList.insertAtHead(2);
        myList.insertAtHead(1);

        myList.head.next.child = myList.new node(6);
        myList.head.next.child.next = myList.new node(7);
        myList.head.next.child.next.prev = myList.head.next.child;
    
        myList.display();
        myList.flatten();
        myList.display();
    }
}
