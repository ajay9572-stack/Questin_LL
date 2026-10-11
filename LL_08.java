public class LL_08 {
// odd even link list
     public class node{
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


   public void oddEvenList() {
        if (head == null || head.next == null) {
            return;
        }
        node odd = head;
        node even = head.next;
        node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        tail = even == null ? odd : even;
    }
     public void insertAtHead(int data) {
        node newNode = new node(data);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void display() {
        node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
     public static void main(String[] args) {
         LL_08 list = new LL_08();
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.display();
        list.oddEvenList();
        list.display();
     }
}
