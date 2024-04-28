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
            String S[] = read.readLine().split(" ");
            
            Long a = Long.parseLong(S[0]);
            Long b = Long.parseLong(S[1]);
            Long x = Long.parseLong(S[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.canReach(a,b,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(Long a, Long b, Long x) {
        // code here
        x -= (Math.abs(a) + Math.abs(b));

        if (x >= 0 && x % 2 == 0)
            return 1;
        else
            return 0;
    }
};