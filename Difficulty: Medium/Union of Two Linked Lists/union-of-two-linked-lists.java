//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

class GfG {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Node inputList() throws IOException {
        String s[] = in.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0]));
        Node copy = head;
        for (int i = 1; i < s.length; i++) {
            Node temp = new Node(Integer.parseInt(s[i]));
            copy.next = temp;
            copy = copy.next;
        }
        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[]) throws IOException {
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head1 = inputList();

            Node head2 = inputList();

            Solution obj = new Solution();

            printList(obj.findUnion(head1, head2));
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    public static Node findUnion(Node head1, Node head2) {
        // Add your code here.
        HashSet<Integer> res= new HashSet<>();
        Node temp1=head1, temp2=head2;
        while(temp1!=null)
        {
            res.add(temp1.data);
            temp1=temp1.next;
        }
        while(temp2!=null)
        {
            res.add(temp2.data);
            temp2=temp2.next;
        }
        Node a=null, b=null;
        int[] arr=new int[res.size()];
        int i =0;
        for(int j:res)
        {
            arr[i++]=j;
        }
        Arrays.sort(arr);
        for(int r:arr)
        {
            Node n = new Node(r);
            if(a==null)
            {
                a=n;
                b=a;
            }
            else
            {
                b.next=n;
                b=n;
            }
        }
        return a;
    }
}