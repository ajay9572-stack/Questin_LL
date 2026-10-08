public class LL_05 {
// merge two sorted linked lists
    public class node {
        int data;
        node next;
        node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private node head;
    private node tail;
    private int size;

    public node merge(node list1,node list2) {
        node dummy = new node(0);
        node temp = dummy;
        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null)
            temp.next = list1;
        if(list2 != null)
            temp.next = list2;
        return dummy.next;
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

    public void display(node head) {
        node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LL_05 list1 = new LL_05();
        list1.insertAtHead(3);
        list1.insertAtHead(2);
        list1.insertAtHead(1);

        LL_05 list2 = new LL_05();
        list2.insertAtHead(10);
        list2.insertAtHead(8);
        list2.insertAtHead(6);
        list2.insertAtHead(4);
        list2.insertAtHead(2);

        node result = list1.merge(list1.head,list2.head);
        list1.display(result);
    }
}