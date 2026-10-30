public class LL_20 {
//split link list into parts
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

    public void insertAtHead(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public node[] split(int k){
       node[] ans = new node[k];
       node temp = head;
       int len =0;
       while(temp != null){
        len++;
        temp = temp.next;
       }
       int baseSize = (len/k);
       int extraNodes = (len%k);

       node prev = null;
       node curr = head;

       for(int part =0; part <k; part++){
        if(curr == null){
            ans[part] = curr;
            continue;
        }
        ans[part] = curr;
        int width = baseSize + (extraNodes >0 ? 1 :0);
        if (extraNodes > 0) {
                extraNodes--;
            }
        for(int i =1; i<= width; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        prev = null;
       }
       return ans;
    }
    public static void main(String[] args) {
        LL_20 myList = new LL_20();
        myList.insertAtHead(10);
        myList.insertAtHead(9);
        myList.insertAtHead(8);
        myList.insertAtHead(7);
        myList.insertAtHead(6);
        myList.insertAtHead(5);
        myList.insertAtHead(4);
        myList.insertAtHead(3);
        myList.insertAtHead(2);
        myList.insertAtHead(1);
        myList.display();
        node[] parts = myList.split(3);
       for (node part : parts) {
            node temp = part;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print("||");
        }
    }
}