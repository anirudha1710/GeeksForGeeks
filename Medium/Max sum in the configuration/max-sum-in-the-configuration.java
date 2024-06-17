//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Your code here
        long current_value = 0;
        long array_sum = 0;
        
        for (int i = 0; i < n; i++) {
            array_sum += a[i];
            current_value += (long)i * a[i];
        }
        
        // Initialize the maximum sum as the current value
        long max_value = current_value;
        
        // Calculate the sum for each rotation
        for (int i = 1; i < n; i++) {
            // Using the relation to get the next sum value
            current_value = current_value + array_sum - (long)n * a[n - i];
            // Update the maximum value
            max_value = Math.max(max_value, current_value);
        }
        
        return max_value;
    }
}
