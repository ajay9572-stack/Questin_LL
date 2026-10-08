public class LL_02 {
// find the mid node of the link list
    public class node {
      int data;
      node next;
      
      node(int data){
        this.data =data;
        this.next = null;
      }
    }
    private node head;
    private node tail;
    private int size;

    public node midNode(){
      node fast = head;
      node slow = head;

      while(fast != null){
        fast = fast.next;
        if(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
      }
      return slow;
    }
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
    private void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        LL_02 myList = new LL_02();
        myList.insertAtHead(10);
        myList.insertAtHead(20);
        myList.insertAtHead(30);
        myList.insertAtHead(40);
        myList.insertAtHead(50);
        myList.insertAtHead(60);
        myList.insertAtHead(70);
        myList.display();
        node mid = myList.midNode();
        System.out.println(mid.data);
    }
}
