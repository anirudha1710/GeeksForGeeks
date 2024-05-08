//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        // code here
        // array to store results of subproblems
        // profit[i] stores maximum profit using at most
        // i transactions up to the current day
        int profit[] = new int[K + 1];
        int prevDiff[] = new int[K + 1];
        Arrays.fill(prevDiff, Integer.MIN_VALUE);
 
        // fill the table in bottom-up fashion
        for (int j = 0; j < N; j++) {
            for (int i = 1; i <= K; i++) {
                prevDiff[i] = Math.max(prevDiff[i], profit[i - 1] - A[j]);
                profit[i] = Math.max(profit[i], A[j] + prevDiff[i]);
            }
        }
 
        return profit[K];
    }
}