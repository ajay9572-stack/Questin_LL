public class LL_15 {
// add two link list 
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
    public node deleteNnode(int m, int n){
        node prev = null;
        node curr = head;
        while (curr != null) {
            for(int i =1; i<= m && curr != null; i++){
                prev = curr;
                curr = curr.next;
            }
            if(curr == null){
                return head;
            }
            for(int i =1 ; i <= n && curr != null; i++){
                curr = curr.next;
            }
            prev.next = curr;
        }
        return  head;
    }
    public static void main(String[] args) {
        LL_15 myList = new LL_15();
        myList.insertAtHead(90);
        myList.insertAtHead(80);
        myList.insertAtHead(70);
        myList.insertAtHead(60);
        myList.insertAtHead(50);
        myList.insertAtHead(40);
        myList.insertAtHead(30);
        myList.insertAtHead(20);
        myList.insertAtHead(10);
        myList.display();
        myList.deleteNnode(2, 3);
        myList.display();
    }
}
