public class LL_06 {
// remove duplicate from shorted link list
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

    public node remvDulicate(){
       if(head == null){
           return head;
       }
       if(head.next == null){
        return  head;
       }
       node prev = head;
       node curr = head.next;
       while(curr != null){
        if(prev.data != curr.data){
            curr = curr.next;
            prev = prev.next;
        }else{
            prev.next = curr.next;
            curr = curr.next;
        }
       }
       return head;
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
    }

    public static void main(String[] args) {
        LL_06 myList = new LL_06();
        myList.insertAtHead(1);
        myList.insertAtHead(2);
        myList.insertAtHead(2);
        myList.insertAtHead(3);
        myList.insertAtHead(3);
        myList.insertAtHead(3);
        myList.insertAtHead(4);
        myList.insertAtHead(4);
        myList.insertAtHead(5);

        myList.remvDulicate();
        myList.display();
    }
}
