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


// } Driver Code Ends

/*
class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node sort(Node head) {
        // your code here, return the head of the sorted list
        ArrayList<Integer> a=new ArrayList<>();
        while(head!=null){
            a.add(head.data);
            head=head.next;
        }
        Collections.sort(a);
        Node h=null,temp=null;
        for(int i=0;i<a.size();i++){
            Node toAdd = new Node(a.get(i));
            if (h == null) {
                h = temp = toAdd;
            } else {
                temp.next = toAdd;
                temp = temp.next;
            }
        }
        return h;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().sort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends