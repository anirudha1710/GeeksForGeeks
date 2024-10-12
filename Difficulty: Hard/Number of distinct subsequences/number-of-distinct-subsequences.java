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
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        // code here
        int MOD = 1000000007;
        int n = S.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        int[] last = new int[26];
        Arrays.fill(last, -1);
        
        for(int i = 1; i <= n; i++) {
            char c = S.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2) % MOD;
            
            if(last[c - 'a'] != -1){
                dp[i] = (dp[i] - dp[last[c - 'a'] - 1] + MOD) % MOD;
            }
            
            last[c - 'a'] = i;
        }
        
        return (int)dp[n];
    }
}