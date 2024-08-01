package JAVA.Recursion_Sorting_LL_stack.Linked_List.Basics;

public class reverse_display_recursion {
    public  static void print(Node temp){
        if(temp == null)
            return;

        print(temp.next);
        System.out.println(temp.val);
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

        print(a);
    }
}
