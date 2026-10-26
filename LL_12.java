public class LL_12 {
//Rotate list to the right 
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
        while ((temp != null)) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    private node rotateRight(node head, int k){
        if(head == null || k ==0){
            return head;
        }
        int len = 1;
        node temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % len;
        temp = head;
        for(int i = 1; i<= len-k-1; i++){
          temp = temp.next;
        }
        node forward = temp.next;
        temp.next = null;

        return forward;
    }
    public static void main(String[] args) {
        LL_12 myList = new LL_12();
        myList.insertAtHead(50);
        myList.insertAtHead(40);
        myList.insertAtHead(30);
        myList.insertAtHead(20);
        myList.insertAtHead(10);
        myList.display();
        myList.head = myList.rotateRight(myList.head, 3);
        myList.display();
    }
}
