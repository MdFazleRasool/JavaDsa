package JAVA.Recursion_Sorting_LL_stack.Linked_List;
class question {
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
        if (index > size) {
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
    void delete(int idx) {
        if(idx > size || idx< 0 ) {
            System.out.println("index out of bound ");
            return;
        }
        if (head == null){
            System.out.println("list is empty ");
            return;
        }
        if(idx == 0){
            head=head.next;
            size--;
            return;
        }
        Node p = head;
        for (int i=0;i<idx-1 ; i++){
            p=p.next;
        }
        if(p.next==tail) {
            tail=p;
        }
        p.next=p.next.next;
        size--;

    }


    int find_element(int idx) throws Error{
        if(idx >= size || idx< 0) {
            throw new Error("Bhai Error handle karle(index)");
        }
        if(idx==0){
            return head.val;
        }
        if(idx == size-1){
            return tail.val;
        }
        Node p = head;
        for (int i = 0; i < idx; i++) {
            p=p.next;
        }
        return p.val;
    }
    void setelement(int val , int idx)   {
        if(idx > size || idx< 0) {
            System.out.println("Bhai Error handle karle(index)");
            return;
        }
        if(idx==0){
            head.val=val;
            return;
        }
        if(idx == size-1){
            tail.val=val;
            return;
        }
        Node p = head;
        for (int i = 0; i < idx; i++) {
            p=p.next;
        }
        p.val=val;
    }


    int length(){
        Node temp = head;
        int len=0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len % 2 == 0 ){
            return len/2;
        }
        else {
            return (len/2) +1 ;
        }
    }

    Node middleRightNode(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return  slow;
    }
    Node middleLeftNode(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return  slow;
    }
    void display() {
        if(head==null){
            System.out.println("Empty list ");
            return;
        }
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







}
public class get_element {

    public static void main(String[] args) {
        question list = new question();
        list.insertAtEnd(30);
        list.delete(-3);
        list.display();
        list.insertAtFront(20);

        list.insertAtFront(0);
        list.insertAtFront(1);
        list.insertAtFront(2);
        list.insertAtIndex(30,3);
        list.insertAtIndex(10,0);
        list.insertAtIndex(40,3); // 0 based indexing
        list.display();
        //System.out.println("element at index 3 is " + list.find_element(3));
        //System.out.println("element at index 3 is " + list.find_element(-1));
        list.setelement(100,3);
        list.display();
        list.delete(4);
        list.display();
        list.delete(4);
        list.display();
        System.out.println("middle index = " + list.length());
        Node temp = list.middleRightNode();
        System.out.println("middle node value =  "+ temp.val);
    }
}
