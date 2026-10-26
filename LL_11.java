public class LL_11 {
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
    }
    public void display(){
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    private node intersection(node headA, node headB){
        if(headA == null || headB == null){
            return null;
        }
        node a = headA;
        node b = headB;
       while (a != b) {

    if (a == null) {
        a = headB;
    } else {
        a = a.next;
    }
    if (b == null) {
        b = headA;
    } else {
        b = b.next;
    }
}
return a;
}
    public static void main(String[] args) {
        LL_11 listA = new LL_11();
        LL_11 listB = new LL_11();
        listA.insertAtHead(50);
        listA.insertAtHead(40);
        listA.insertAtHead(30);
        listA.insertAtHead(20);
        listA.insertAtHead(10);
        listA.display();
       
        listB.insertAtHead(66);
        listB.insertAtHead(55);
        listB.insertAtHead(40);
        listB.insertAtHead(35);
        listB.insertAtHead(25);
        listB.insertAtHead(15);
        listB.display();

       node result = listA.intersection(listA.head, listB.head);
       if(result != null){
        System.out.println(result.data);
       }else{
        System.out.println("no intersection");
       }
    }
}
