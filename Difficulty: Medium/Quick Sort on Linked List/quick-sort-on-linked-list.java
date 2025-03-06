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

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
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
// you have to complete this function
class GfG {
    public static Node quickSort(Node node) {
        ArrayList<Integer> elemets = new ArrayList<>();
        
        Node temp = node;
        int count = 0;
        while(temp != null){
            elemets.add(temp.data);
            count++;  
            temp = temp.next;
        }
        

         int[] elemetsArray = new int[count];
        for(int i=0; i<count; i++){
            elemetsArray[i] = elemets.get(i);
        }
        
      quickSort(elemetsArray, 0 , elemetsArray.length - 1);
      
        temp = node;
        int i = 0;
        while(temp != null){
            temp.data = elemetsArray[i++];
            temp = temp.next;
        }
        return node;
      
    } 
        
        
    private static int partition(int[]arr,int low,int high){
        int pi=arr[high];
        int i=low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pi){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
        
    public static void quickSort(int[]arr,int low,int high){
        if(low<high){
            int pivotIndex = partition(arr,low,high);
            quickSort(arr, low , pivotIndex-1);
            quickSort(arr, pivotIndex+1 , high);
        }
    }
}