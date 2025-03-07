//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends

/*
Structure of node class is:
class Node {
    char data;
    Node next;

    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {

    public Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list
        Node head1 = null;
        Node head2 = null;
        Node p1 = null;
        Node p2 = null;
        Node curr = head;
        while(curr!=null) {
            if(curr.data=='a' || curr.data=='e' || curr.data=='i' || curr.data=='o' || curr.data=='u') {
                if(head1==null) {
                    Node ele = new Node(curr.data);
                    head1=ele;
                    p1 = ele;
                } else {
                    Node ele = new Node(curr.data);
                    p1.next=ele;
                    p1 = p1.next;
                }
            } else{
                if(head2==null) {
                    Node ele = new Node(curr.data);
                    head2=ele;
                    p2 = ele;
                } else {
                    Node ele = new Node(curr.data);
                    p2.next=ele;
                    p2 = p2.next;
                }
            }
            curr = curr.next;
        }
        if(head1 == null) {
            return head2;
        }
        p1.next = head2;
        return head1;
    }
}


//{ Driver Code Starts.

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().split(" ");
            int n = str.length;
            Node head = null, tail = null;

            char head_c = str[0].charAt(0);
            head = new Node(head_c);
            tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(str[i].charAt(0));
                tail = tail.next;
            }

            Solution obj = new Solution();

            show(obj.arrangeCV(head));
            System.out.println("~");
        }
    }

    public static void po(Object o) { System.out.println(o); }

    public static void show(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends