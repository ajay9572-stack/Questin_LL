public class LL_22 {
// double of link list
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
       private node reverse( node head){
        node curr= head;
        node prev = null;
        
        while (curr != null){
           node forward = curr.next;
            curr.next =prev;
            prev = curr;
            curr = forward;
        }
        return  prev;
    }

public  node doubleLL() {
    head = reverse(head);

    node dummy = new node(-1);
    node curr = dummy;

    node temp = head;
    int carry = 0;

    while (temp != null ) {
        int value = temp.data;
        int sum = value + value + carry;
        int digit = sum % 10;

        curr.next = new node(digit);
        curr = curr.next;
        carry = sum / 10;
        temp = temp.next;
    }
    if(temp == null && carry != 0){
        curr.next = new node(carry);
    }
    dummy = dummy.next;
    head = reverse(dummy);
   return  head;
}
public static void main(String[] args) {
        LL_22 myList = new LL_22();
        myList.insertAtHead(9);
        myList.insertAtHead(8);
        myList.insertAtHead(7);
        myList.display();
        myList.doubleLL();
        myList.display();
    }
}
