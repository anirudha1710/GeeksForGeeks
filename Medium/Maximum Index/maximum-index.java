//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int maxDiff = 0 ;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            if(st.isEmpty()){
                st.push(i);
            }else{ 
              if(a[st.peek()] < a[i])  st.push(i);
            }
        }
        // System.out.println(st.peek());
        for(int i = 0 ; i < n ; i++){
            
        while(!st.isEmpty() && a[st.peek()] >= a[i]){
           
            maxDiff = Integer.max(maxDiff , st.peek() - i );
            st.pop();
        }
        if(st.isEmpty())break;
        }
        return maxDiff;
        
    }
}


