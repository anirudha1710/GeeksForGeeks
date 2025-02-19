//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();

            Node result = obj.mergeResult(head1, head2);
            printList(result);
        }
        sc.close();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
} */

class Solution {
    Node mergeResult(Node node1, Node node2) {
        // Your code here
        Node ans = null;
         Node temp = null;
         while(node1 != null && node2 != null)
         {   
             if(node1.data < node2.data)
             {
                 temp = new Node(node1.data);
                 temp.next = ans;
                 ans = temp;
                 node1 = node1.next;
             }
             else
             {
                 temp = new Node(node2.data);
                 temp.next = ans;
                 ans = temp;
                 node2 = node2.next;
             }
         }
         if(node1 != null)
         {
             while(node1 != null)
             {
                 temp = new Node(node1.data);
                 temp.next = ans;
                 ans = temp;
                 node1 = node1.next;
             }
         }
         if(node2 != null)
         {
             while(node2 != null)
             {
                 temp = new Node(node2.data);
                 temp.next = ans;
                 ans = temp;
                 node2 = node2.next;
             }
         }
         return ans;
    }
}
