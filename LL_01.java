public class LL_01 {
    // reverse a link list
    static class node {
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

    private void insertAtHead(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

private void reverse(){
    node prev = null;
    node curr = head;
    while(curr != null){
        node forward = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forward;
    }
    head = prev;
}

    private void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LL_01 myList = new LL_01();
        myList.insertAtHead(10);
        myList.insertAtHead(20);
        myList.insertAtHead(30);
        myList.insertAtHead(40);
        myList.insertAtHead(50);
        myList.display();
        myList.reverse();
        myList.display();
    }
}