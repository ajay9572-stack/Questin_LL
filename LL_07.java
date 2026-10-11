public class LL_07 {

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

  private int knode(int k){
    if(k <0 && head == null){
        return -1;
    }
      node prev = head;
      node curr = head;
      for(int i = 0; i<=k; i++){
        curr =  curr.next;
      }
      while(curr != null){
        curr = curr.next;
        prev =  prev.next;
      }
      return prev.data;
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
        LL_07 myList = new LL_07();
        myList.insertAtHead(50);
        myList.insertAtHead(40);
        myList.insertAtHead(30);
        myList.insertAtHead(20);
        myList.insertAtHead(10);
        myList.display();
        System.out.println();
        System.out.println(myList.knode(2));
    }
}
