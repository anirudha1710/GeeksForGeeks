//{ Driver Code Starts
import java.io.*; // Import for BufferedReader, InputStreamReader, and IOException
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
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void addressStore(Node[] arr, Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

    public static boolean check(Node[] before, Node[] after, int num, int k) {
        if (k > num) return true;

        for (int i = 0; i < num; i++) {
            if ((i == k - 1) || (i == num - k)) {
                if (!((before[k - 1] == after[num - k]) &&
                      (before[num - k] == after[k - 1]))) {
                    return false;
                }
            } else {
                if (before[i] != after[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            // Parse input line into integers
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int k = Integer.parseInt(br.readLine());

            // Create the linked list
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            int num = arr.size();
            Node[] before = new Node[num];
            addressStore(before, head);

            Solution ob = new Solution();
            head = ob.swapKthNode(head, k);

            Node[] after = new Node[num];
            addressStore(after, head);

            // Check if the swap was successful
            if (check(before, after, num, k)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public Node swapKthNode(Node head, int k) {
        // code here
        int n=0;
        Node curr=head;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        if(k>n || k==n-k+1){
            return head;
        }
        
        Node x=head,x_prev=null;
        Node y=head,y_prev=null;
        
        int i=1;
        while(i<k){
            x_prev=x;
            x=x.next;
            i++;
        }
        
        int j=1;
        while(j<n-k+1){
            y_prev=y;
            y=y.next;
            j++;
        }
        
        if(x_prev!=null){
            x_prev.next=y;
        }
        if(y_prev!=null){
            y_prev.next=x;
        }
        
        Node temp=x.next;
        x.next=y.next;
        y.next=temp;
        
        if(k==1){
            return y;
        }
        if(k==n){
            return x;
        }
        
        
        return head;
    }
}