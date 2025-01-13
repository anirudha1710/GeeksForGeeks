//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("PUT")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.put(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    static Map<Integer, DLListNode> hm;
    static DLListNode head, tail;
    static int capacity;

    LRUCache(int cap) {
        capacity = cap;
        hm = new HashMap<>(cap);
        head = new DLListNode(0, 0);
        tail = new DLListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        DLListNode n = hm.get(key);
        moveLast(n);
        return n.val;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (hm.containsKey(key)) {
            DLListNode node = hm.get(key);
            node.val = value;
            moveLast(node);
        } else {
            if (hm.size() >= capacity) {
                remove(head.next);
            }
            DLListNode newNode = new DLListNode(key, value);
            addNode(newNode);
        }
    }

    public static void remove(DLListNode node) {
        if (!hm.containsKey(node.key))
            return;
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void moveLast(DLListNode node) {
        if (!hm.containsKey(node.key))
            return;
        remove(node);
        addNode(node);
    }

    public static void addNode(DLListNode node) {
        if (node == null)
            return;
        hm.put(node.key, node);
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}

class DLListNode {
    int key, val;
    DLListNode next;
    DLListNode prev;

    DLListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}