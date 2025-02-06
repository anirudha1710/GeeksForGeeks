//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    static Node reverseList(Node head){
        Node prev = null;
        Node next = null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        
      if (head.next == null){
            head.data = head.data +1;
            return head;
        }
        
        Node og = head;
        // code here.
        Node revhead = reverseList(og);
        Node temp = revhead;
        int count =0;
// start to count only when the last digit is 9
        if(temp.data == 9){
            temp.data = 0;
            count++;
        }
        Node curr = revhead.next;

// now start from the next number and perform the operations
        if(count > 0){
            while(curr.next != null){
                if(curr.data == 9 && count > 0){
                    curr.data = 0;
                    count = 1;
                }

                else if (count >0){
                    curr.data = curr.data+1;
                    count--;
                }
                curr = curr.next;
            }
            
            if(count > 0){
                curr.data = curr.data +1;
            }
        }
        
        else{
            temp.data = temp.data +1;
        }
        
        reverseList(temp);
        
        return head;
        
    }
}
