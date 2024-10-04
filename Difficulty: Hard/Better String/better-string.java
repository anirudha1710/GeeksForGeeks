//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // code here
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);
        
        if (count1 >= count2) {
            return str1;
        } else {
            return str2;
        }
    }
    
    private static int countDistinctSubsequences(String s) {
        int n = s.length();
        int[] dp = new int[n + 1]; 
        dp[0] = 1;  
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            char currentChar = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];  
            
            if (lastOccurrence.containsKey(currentChar)) {
                int lastIndex = lastOccurrence.get(currentChar);
                dp[i] -= dp[lastIndex - 1];  
            }
            
            
            lastOccurrence.put(currentChar, i);
        }
        
        
        return dp[n];
    }
}