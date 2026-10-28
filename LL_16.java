public class LL_16 {
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
    public node addTwoNode(node l1, node l2){
        int carry = 0;
        node ansHead = new node(-1);
        node ansTail = ansHead;

        while(l1 != null|| l2 != null || carry != 0){
             int sum =0;
             if(l1 != null){
                sum = sum +l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum+ l2.data;
                l2 = l2.next;
            }
            sum = sum + carry;
            int digit = sum %10;
            carry = sum/10;

            node newNode = new node(digit);
            ansTail.next = newNode;
            ansTail = newNode;
        }
        return ansHead.next;
    }
    public static void main(String[] args) {
        LL_16 list1 = new LL_16();
        LL_16 list2 = new LL_16();
        list1.insertAtHead(3);
        list1.insertAtHead(4);
        list1.insertAtHead(2);
        list1.display();
        
        list2.insertAtHead(4);
        list2.insertAtHead(6);
        list2.insertAtHead(5);
        list2.display();

       node result = list1.addTwoNode(list1.head, list2.head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
