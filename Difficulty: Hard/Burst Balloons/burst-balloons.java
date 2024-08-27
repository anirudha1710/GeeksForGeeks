//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] a) {
    // code here
    int arr[] = new int[N+2];
      arr[0] = arr[N+1] = 1;  
      

      for(int i = 1 ; i <= N ; i++){
          arr[i] = a[i-1];
      }
      
      int dp[][] = new int[N+1][N+1];
      for(int[] row : dp){
          Arrays.fill(row , -1);
      }
      return count(1 , N , arr , dp);
  }
  
  public static int count(int i, int j , int[] arr , int dp[][]){
      
      if(i > j) return 0;
      
      if(dp[i][j] != -1) return dp[i][j];
      
      int ans = Integer.MIN_VALUE;
      
      for(int k = i ; k <= j ; k++){
          int coins = arr[i-1] * arr[k] * arr[j+1] 
                      + count(i , k-1 , arr , dp)
                      + count(k+1 , j , arr , dp);
                      
          ans = Math.max(ans , coins);              
      }
      
      return dp[i][j] = ans;
  }
}
     