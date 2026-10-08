public class LL_04 {
// check cycle in link list
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

    public boolean hasCycle() {
        node fast = head;
        node slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
// for create cycle if dont then always return false
    public void createCycle() {
    tail.next = head;      // if we want to move cycle position then use head.next, head.next.next...
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
    public void dispaly(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
      LL_04 myList = new LL_04();
      myList.insertAtHead(1);
      myList.insertAtHead(2);
      myList.insertAtHead(3);
      myList.insertAtHead(2);
      myList.insertAtHead(1);
      myList.createCycle();
      System.out.println(myList.hasCycle());
    }
}
