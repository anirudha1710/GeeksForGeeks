//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.maxStairHeight(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxStairHeight(int N) {
        // code here
        int number= (int)(Math.sqrt((8*N)+1)-1)/2;
        return number;
    }
};