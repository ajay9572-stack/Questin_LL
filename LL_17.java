public class LL_17 {
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
    public node detectStartingNode(){
        node fast = head;
        node slow = head;
        boolean hasCycle = false;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle == false){
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        node startingNode = slow;
        return startingNode;
    }

    public void createCycle(int position) {
     node temp = head;
     node cycleNode = null;
     int count = 0;
     while (temp.next != null) {
         count++;
         if (count == position) {
            cycleNode = temp;
         }
         temp = temp.next;
        }
        temp.next = cycleNode;
    }
    public static void main(String[] args) {
        LL_17 myList = new LL_17();
        myList.insertAtHead(8);
        myList.insertAtHead(7);
        myList.insertAtHead(6);
        myList.insertAtHead(5);
        myList.insertAtHead(4);
        myList.insertAtHead(3);
        myList.insertAtHead(2);
        myList.insertAtHead(1);
        myList.display();
        myList.createCycle(4);
        node start = myList.detectStartingNode();
        if(start != null){
            System.out.println(start.data);
        }else{
            System.out.println("no cycle");
        }
    }
}
