//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int[][] dp;
    int[][] cost;
    int numcity;
    int VISITED_ALL;
    public int total_cost(int[][] cost) {
        // Code here
        this.numcity = cost.length;
        this.cost = cost;
        this.dp = new int[1<<numcity][numcity];
        this.VISITED_ALL = (1<<numcity)-1;
        for(int i=0;i<(1<<numcity);i++)
        {
            for(int j=0;j<numcity;j++)
            {
                dp[i][j] = -1;
            }
        }
        
        return tsp(1,0);
    }
    public int tsp(int mask, int pos)
    {
        if(mask == VISITED_ALL)
            return cost[pos][0];
        
        if(dp[mask][pos] != -1)
            return dp[mask][pos];
           
        int ans = Integer.MAX_VALUE; 
        for(int city=0;city<numcity;city++)
        {
            if((mask&(1<<city))==0)
            {
                int newans = cost[pos][city] + tsp(mask|(1<<city), city);
                ans = Math.min(ans, newans);
            }
        }
        return dp[mask][pos] = ans;
        
    }
}