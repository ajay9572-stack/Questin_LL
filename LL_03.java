public class LL_03 {
// find palindrome of a link list
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

 //find mid point   
    public node midpoint(node head){
        node slow = head;
        node fast = head;
         while(fast != null){
            fast = fast.next;
            if(fast!= null){
                fast = fast.next;
                slow = slow.next;
            }
         }
         return slow;
    }
 // reverese 
    public node reverse(node head){
        node prev = null;
        node curr = head;
        while(curr != null){
            node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }


    public boolean isPalindrome() {
   //break mid point
        node list2 = midpoint(head);
   // seprate list1, list2
        node temp = head;
       if(temp.next != list2){
            temp = temp.next;
        }else{
            temp.next = null;
        }
   //revrse list 2
        node head2 = reverse(list2);
   //compare list1 list 2
        node temp1 = head;
        node temp2 = head2;

        while(temp1 != null && temp2 != null){ // if temp1 and temp2 are not null then check either
            if(temp1.data != temp2.data){         // temp1 data and temp2 data are equal or not
                return false;
            }else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
       return true;
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
            System.out.println(temp.data +" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LL_03 myList = new LL_03();
        myList.insertAtHead(1);
        myList.insertAtHead(2);
        myList.insertAtHead(3);
        myList.insertAtHead(2);
        myList.insertAtHead(1);
        System.out.println(myList.isPalindrome());
    }
}
