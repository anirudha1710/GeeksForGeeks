//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][]dp = new int[wt.length][capacity +1];
        for(int i = 0;i < wt.length; i++){
            for(int cap = 1; cap <= capacity ;cap++){
                if(i == 0) {
                    if(cap >= wt[i]) dp[i][cap] = val[i];
                }
                else{
                    int exc = dp[i-1][cap];
                    int inc =0 ;
                    if(cap >= wt[i]) {
                    inc = dp[i-1][cap - wt[i]] + val[i];
                    }
                    dp[i][cap] = Math.max(exc, inc);
                }
            }
        }
        return dp[wt.length -1][capacity];
    }
}
