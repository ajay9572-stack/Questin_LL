public class LL_01 {
    static class node {
        int data;
        node next;

        node (int data){
            this.data = data;
            this.next = null;
        }   
    }
    private node head;
    private node tail;
    private int size;

    private void reverse(){
       node prev = null;
       node curr = head;
        while(curr != null){
            node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return;
    }
    private void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LL_01 myList = new LL_01();
        myList.reverse();
        myList.display();
    }
}
