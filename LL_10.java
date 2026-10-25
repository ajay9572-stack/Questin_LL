public class LL_10 {
// add 1 to a link list number
    public class node {
    int data;
    node next;
    node(int data){
        this.data = data;
        this.next = null;
    }    
    }
    private node head;
    private node tail;
    private int size;

    public void insertAtHead(int data){
        node newNode = new node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data);
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

private node addOne() {
    head = reverse(head);
    node curr = head;
    int carry = 1;

    while (curr != null && carry > 0) {
        int sum = curr.data + carry;
        curr.data = sum % 10;
        carry = sum / 10;
        if (curr.next == null && carry > 0) {
            curr.next = new node(carry);
            tail = curr.next;
            carry = 0;
        }
        curr = curr.next;
    }
    head = reverse(head);
    return head;
}

    public static void main(String[] args) {
        LL_10 myList = new LL_10();
        myList.insertAtHead(9);
        // myList.insertAtHead(8);
        // myList.insertAtHead(7);
        myList.display();
        myList.addOne();
        myList.display();
    }
}