//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int m = arr.length;
        int total = 0;
        for (int i : arr) {
            total += i;
        }

        int n = total / 2 + 1;
        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = (i == 0) || (i == arr[0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < arr[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i]) {
                min = Math.min(min, total - 2 * i);
            }
        }

        return min;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends