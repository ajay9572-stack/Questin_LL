public class LL_14 {
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
            head = tail= newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public node swapKthnode( int k){
        node first = head;
        for(int i = 1; i <=(k-1); i++){
            first = first.next;
        }
        node temp = first.next;
        node second = head;
        while (temp != null) {
           temp = temp.next;
           second = second.next; 
        }
        int tempVal = first.data;
        first.data = second.data;
        second.data = tempVal;
        return head;
    }
    public static void main(String[] args) {
        LL_14 myList = new LL_14();
        myList.insertAtHead(50);
        myList.insertAtHead(40);
        myList.insertAtHead(30);
        myList.insertAtHead(20);
        myList.insertAtHead(10);
        myList.display();
        myList.swapKthnode( 2);
        myList.display();
    }
}
