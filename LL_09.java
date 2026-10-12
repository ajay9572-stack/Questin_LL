public class LL_09 {
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

    public void megreNode(){
        node write = head;
        node read = head.next;

        while(read != null){
            int sum = 0;
            while(read.data != 0){
                sum = sum + read.data;
                read = read.next;
            }
            write.data = sum;
            write.next = read.next;
            read = read.next;
            write = write.next;
        }
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
    }

    public void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
       System.out.println();
    }
    public static void main(String[] args) {
      LL_09 myList = new LL_09();
      myList.insertAtHead(0);
      myList.insertAtHead(3);
      myList.insertAtHead(2);
      myList.insertAtHead(0);
      myList.insertAtHead(4);
      myList.insertAtHead(5);
      myList.insertAtHead(6);
      myList.insertAtHead(0);
      myList.display();
      myList.megreNode();
      myList.display();
       
    }   
}
