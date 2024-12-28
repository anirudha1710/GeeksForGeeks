//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int table[][] = new int[n+1][target+1];
        
        for( int i =1; i<= target; i++){
            table[0][i] = 0; // we can't create have any subset whose sum will be greater than than 0 given that we have 0 elemnts to select from
        }
        for( int i =0; i<= n; i++){
            table[i][0] = 1; // we can create an empty set to obtain sum = 0
        }
        
        for(int i = 1; i<= n; i++){
            for(int j = 0; j<= target; j++){
                
                if(nums[i-1] <= j  ){
                    table[i][j] = table[i-1][j-nums[i-1]] + table[i-1][j];
                } else{
                    table[i][j] = table[i-1][j];
                }
                
            }
        }
        return table[n][target];
    }
}