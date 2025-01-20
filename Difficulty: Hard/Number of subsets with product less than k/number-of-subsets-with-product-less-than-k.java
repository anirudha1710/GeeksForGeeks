//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                try {
                    array.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + token);
                    return; // If any invalid input is encountered, stop the program
                }
            }

            String kInput = br.readLine();
            if (kInput == null || kInput.isEmpty()) continue;

            int k = Integer.parseInt(kInput);

            // Convert the ArrayList to an array
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();
            int res = obj.numOfSubsets(arr, k);

            // Output the result
            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int numOfSubsets(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        int[][] dp = new int[n+1][k+1];
        int sum = 0;
        
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 0; j<=k; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=k; j++){
                dp[i][j] = dp[i-1][j];
                
                if(arr[i-1] <= j){
                    dp[i][j] += dp[i-1][j/arr[i-1]]+1;
                }
            }
        }
        
        
        
        return dp[n][k];
    }
};