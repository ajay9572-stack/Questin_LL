public class LL_13 {
 // short link list of 0's, 1's, 2's
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

    public void insertAtHead(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void sortList() {
        node zeroHead = new node(-1);
        node zeroTail = zeroHead;
        node oneHead = new node(-1);
        node oneTail = oneHead;
        node twoHead = new node(-1);
        node twoTail = twoHead;

        node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = temp;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = temp;
            } else if (temp.data == 2) {
                twoTail.next = temp;
                twoTail = temp;
            }
            temp = temp.next;
        }
        twoTail.next = null;
        oneTail.next = twoHead.next;
        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;

        head = zeroHead.next;
    }

    public static void main(String[] args) {
        LL_13 list = new LL_13();

        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtHead(0);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtHead(0);
        list.display();
        list.sortList();
        list.display();
    }
}
