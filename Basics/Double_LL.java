package JAVA.Recursion_Sorting_LL_stack.Linked_List;
class Node {
    int val;
    Node pre;
    Node next;
    Node(int val){
        this.val=val;
    }
}

class DLL {
    private Node head;
    private Node tail;
    private int size =0 ;
    public void display(){
        Node temp = head;
        if(temp == null){
            System.out.println("empty linked list");
           return;
        }
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void insert_at_start(int data) {
        Node temp = new Node(data);
        if(head == null ){
            tail=head=temp;
            return;
        }
        else {
            temp.next=head;
            head.pre=temp;
            head=temp;
        }
        size+=1;
    }

    public void insert_at_end(int data) {
        Node temp = new Node(data);
        if(head == null ){
            insert_at_start(data);
            return ;
        }
        Node p = head;
        while(p.next != null){
            p=p.next;
        }
        p.next=temp;
        temp.pre=p;
        tail=temp;
        size+=1;
    }
    public void insert_at_index(int data  , int idx){
        if(idx<0){
            System.out.println("idx less than 0");
            return;
        }
        if(idx == 0 || head == null ){
            insert_at_start(data);
            return;
        }
        Node temp = new Node(data);
        Node p = head;
        for (int i = 1; i < idx-1; i++) {
            if(p.next == null){
                System.out.println("index greater");
                return;
            }
            p=p.next;
        }
        //insert at tail or end
        if(p.next == null){
            temp.pre=p;
            p.next=temp;
            tail=temp;
            return;
        }
        temp.next=p.next;
        temp.pre= p;
        p.next=temp;
        p=temp.next;
        p.pre=temp;
        size+=1;
    }
    public void delete_at_front(){
        if(head == null) {
            System.out.println("Empty linkeed list");
            return;
        }
        else {
            head = head.next;
            head.pre=null;

        }
    }
    public void delete_at_end(){
        if(head == null) {
            System.out.println("Empty linkeed list");
            return;
        }
        Node p = head;
        while (p.next.next!= null){
            p=p.next;
        }

        Node last = p.next;
        last.pre=null;
        p.next=null;
    }
    public void delete_at_index(int idx){
        if(idx <0) {
            System.out.println("negative index provided");
            return;
        }
        if(idx==0) {
            delete_at_front();
            return;
        }
        Node p =head;
        for (int i = 1; i < idx; i++) {
            if (p.next==null){
                System.out.println("index provided greater than length");
                return;
            }
            if(p.next.next == null){
                delete_at_end();
                return;
            }
            p=p.next;

        }
        Node del = p.next;
        p.next=del.next;
        del.next=null;
        del.pre=null;
        p.next.pre=p;


    }

}

public class Double_LL {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insert_at_start(10);
        list.insert_at_end(20);
        list.insert_at_index(30,3);
        list.insert_at_end(40);
        list.display();
        /*list.delete_at_front();
        list.delete_at_end();*/
       list.delete_at_index(3);
        list.display();
    }
}
