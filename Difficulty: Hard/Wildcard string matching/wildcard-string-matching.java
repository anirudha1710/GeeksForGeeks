//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean f(String wild, String pattern , int m , int n,Boolean[][] dp){
        // code here
        if(m<0 && n<0){
            return true;
        }
         if(m<0 && n>=0){
            return false;
        }
         if(n<0 && m>=0){
            boolean ch = true; 
            for(int i = m;i>=m;i--){
                if(wild.charAt(i) != '*'){
                   return false;
                }
            }
            return ch;
        }
         if (dp[m][n] != null) return dp[m][n];
         if(wild.charAt(m) == '?' || wild.charAt(m) == pattern.charAt(n)){
            boolean val =  f(wild,pattern,m-1,n-1,dp);
            dp[m][n] = val;
            return val;
        }
         if (wild.charAt(m) == '*'){
            boolean val =  f(wild,pattern,m,n-1,dp) || f(wild,pattern,m-1,n,dp);
            dp[m][n] = val;
            return val;
        }
        else {
            return false;
        }
    }
    
    static boolean match(String wild, String pattern)
    {
        // code here
        int m = wild.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i = 0;i<=m;i++){
            for(int j =0 ;j<=n;j++){
                if(i==0 && j==0){
                    dp[i][j] =true;
                }
                
                else if(j==0){
                    boolean ch = true;
                    for(int k = 1;k<=i;k++){
                if(wild.charAt(k-1) != '*'){
                   ch= false;
                   break;
                }
            }
            dp[i][j] = ch;
            
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                
                else if(wild.charAt(i-1) == '?' || wild.charAt(i-1) == pattern.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
                }
                
                else  if (wild.charAt(i-1) == '*'){
                    
             dp[i][j] = dp[i-1][j] ||dp[i][j-1];
        }
        else{
            dp[i][j] = false;
        }
            }
        }
        
       
        return dp[m][n];
    }
}