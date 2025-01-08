//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    public static int[] nse(int[] a){
        int[] n = new int[a.length];
        Stack <Integer> nse = new Stack<>();

        for(int i=a.length-1; i>=0; i--){

            while(!nse.isEmpty() && a[i]<=a[nse.peek()]){
                nse.pop();
            }

            if(nse.isEmpty()){
                n[i] = a.length;
            }
            else{
                n[i] = nse.peek();
            }
            nse.push(i);
        }

        return n;
    }

    public static int[] pse(int[] a){
        int[] p = new int[a.length];
        Stack<Integer> pse = new Stack<>();

        for(int i=0; i<a.length; i++){
            while(!pse.isEmpty() && a[pse.peek()]>a[i]){
                pse.pop();
            }
            if(pse.isEmpty()){
                p[i] = -1;
            }
            else{
                p[i] = pse.peek();
            }
            pse.push(i);
        }

        return p;
    }
    
    // Function to find largest rectangular area possible in a given histogram.
    public static int getMaxArea(int arr[]) {
        // your code here
        
        int area = 0;
        int[] nse = nse(arr);
        int[] pse = pse(arr);

        for(int i=0; i<arr.length; i++){
            int max = (nse[i]-pse[i]-1)*arr[i];
            area = Math.max(area, max);
        }

        return area;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends