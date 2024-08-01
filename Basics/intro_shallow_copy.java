package JAVA.Recursion_Sorting_LL_stack.Linked_List.Basics;


class Node {
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}
public class intro_shallow_copy {
    public static void shallow199(Node temp){
        Node head = temp ; // shallow copy
        System.out.println("head = " + head.val);
        System.out.println("temp = " + temp.val);
        System.out.println("head address  " + head + " ," + " temp address " + temp);
        head.val=100;
        System.out.println("value of both changes after changing the value of head in shallow copy ");
        System.out.println("head = " + head.val);
        System.out.println("temp = " + temp.val);
        deep199(temp);
    }
    public static void deep199(Node temp){
        System.out.println("Deep copy faunction called");
        Node head = new Node(temp.val);// deep copy
        System.out.println("head = " + head.val);
        System.out.println("temp = " + temp.val);
        System.out.println("head address  " + head + " ," + " temp address " + temp);
        head.val=200;
        System.out.println("value  of head node does not  changes  in deep copy ");
        System.out.println("head = " + head.val);
        System.out.println("temp = " + temp.val);
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        a.next=b;   // 10 ->20
        b.next=c;   // 10 -> 20 ->30
        c.next=d;   // 10 -> 20 ->30 -> 40
        d.next=e;   // 10 -> 20 ->30 -> 40 -> 50
        shallow199(a);
        /*System.out.println(a.val);
        System.out.println(a.next.val);
        System.out.println(a.next.next.val);
        System.out.println(a.next.next.next.val);
        System.out.println(a.next.next.next.next.val);
        */








    }
}
