package JAVA.Recursion_Sorting_LL_stack.Linked_List;
/*class Node {
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}*/

class Sll {
    private Node head;
    private Node tail;
    private int size;

    void insertAtEnd(int data) {
        Node temp = new Node(data);
        if(head==null){
            head=tail=temp;
        }
        else {
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    void insertAtFront(int data) {
        Node temp = new Node(data);
        if (head== null){
            head=tail=temp;

        }
        else {
            temp.next=head;
            head=temp;
        }
        size++;
    }
    void insertAtIndex(int data , int index) {
        Node temp = new Node(data);
        if (index > size || index < 0) {
            System.out.println("input index is greater than linked list size ");
            return;
        }
        if (index==0){
            insertAtFront(data);
            return;
        }
        if (index==size) {
            insertAtEnd(data);
            return;
        }
        Node p = head;
        for (int i = 0; i < index-1; i++) {
            p=p.next;
        }
        temp.next=p.next;
        p.next=temp;
        size++;
    }




    void display(Node head1) {
        Node temp = head1;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    void size(){
        System.out.println("Length of linked list :- " + size);
    }
    void delete_right_middle(){
        Node slow = head;
        Node fast = head;
        while(fast.next!= null && fast.next.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

    }
    Node merge_remove(Node list1 , Node list2 , int a , int b ) {
        Node temp1 = list1 ;
        //display(temp1);
        Node temp2 = null ;
        Node temp3 = null ;
        Node temp4 = list2 ;
        while(temp1 != null) {

            if(temp1.next.val == b) {
                temp3 = temp1;
                break;
            }
            if(temp1.next.val == a) {
                temp2 = temp1;
            }
            temp1= temp1.next;
        }
        while(temp4.next != null) {
            temp4=temp4.next;
        }
        temp3=temp3.next;
        temp2.next=list2;
        temp4.next=temp3.next;
        temp3.next=null;




        return list1;
    }
    Node swapping (Node list1 , int k) {
        Node temp1 = list1;
        Node temp2 =null;
        Node temp3 =list1;

        for (int i = 0; i < k-1; i++) {
            temp1= temp1.next;
        }
        temp2 = temp1;
        while(temp2.next != null) {
            temp2= temp2.next;
            temp3=temp3.next;
        }
        int temp = temp1.val;
        temp1.val=temp3.val;
        temp3.val=temp;


        return list1;
    }
    void length_loop1 (Node head1){

        Node slow = head1;
        Node fast = head1;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) break;
        }
        if (fast == null || fast.next == null) {
            System.out.println("no loop");
            return;
        }
        fast=head1;
        while(fast != slow) {
            fast=fast.next;
            slow=slow.next;
        }
        int len = 1;

        while(slow.next != fast) {
            len++;
            slow=slow.next;
        }
        System.out.println("length of cycle = " + len);

    }
}
public class single_LL {
    public static void main(String[] args) {
        Sll list5 = new Sll();
        /*list.insertAtFront(6);
        list.insertAtFront(5);
        list.insertAtFront(4);
        list.insertAtFront(6);
        list.insertAtFront(3);
        list.insertAtFront(2);
        list.insertAtFront(1);
        list.del_duplicate();
        list.print();*/
        list5.delete_right_middle();




        Node a = new Node(0);
        Node a1 = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node p = new Node(5);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);


        a.next = a1;
        a1.next = b;
        b.next = c;
        c.next = d;
        d.next = p;
        p.next=e;
        e.next=f;
        f.next=g;
        g.next=d;
        list5.length_loop1(a);
        list5.merge_remove(a, a , 2 , 5);
        /*Node x = new Node(600);
        Node y = new Node(700);
        Node z = new Node(800);
        x.next = y;
        y.next = z;
        z.next=null;
        list.display(a);

        list.display(a);
        list.swapping(a,2);
        list.display(a);*/

    }


}