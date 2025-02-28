//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Rearr {
    static Node head;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
            System.out.println("~");
        }
    }

    public static void printLast(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution {
    public static void rearrange(Node head) {
        // add your code here
        if(head.next==null || head.next.next==null) return;
        Node odd = head;
        Node oddMove = odd;
        Node even = null;
        
        while(oddMove!=null && oddMove.next!=null){
            Node tempEven = oddMove.next;
            oddMove.next = tempEven.next;
            tempEven.next = even;
            even = tempEven;
            if(oddMove.next!=null)
                oddMove = oddMove.next;
        }
        oddMove.next = even;
    }
}
