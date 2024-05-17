//{ Driver Code Starts
//Initial Template for Java

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
            System.out.println(ob.countNumberswith4(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean contains(int N){
        while(N>0){
            if(((N%10)^4)==0)
                return true;
            N/=10;
        }
        return false;
    }
    static int countNumberswith4(int N) {
        // code here
        if(N<1)
            return 0;
        if(contains(N))
            return 1 + countNumberswith4(N-1);
        else
            return countNumberswith4(N-1);
    }
};