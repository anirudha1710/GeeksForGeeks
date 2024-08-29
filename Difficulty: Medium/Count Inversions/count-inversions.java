//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        return mergeSortAndCount(arr, 0, n - 1);
       
    }
     private static long mergeSortAndCount(long[] arr, int left, int right) {
        long cnt = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Recursively count inversions in left and right halves
            cnt += mergeSortAndCount(arr, left, mid);
            cnt += mergeSortAndCount(arr, mid + 1, right);
            
            // Count inversions during the merge process
            cnt += mergeAndCount(arr, left, mid, right);
        }
        return cnt;
    }
    
    private static long mergeAndCount(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        long cnt = 0;
        
        // Merge and count inversions
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                cnt += (mid - i + 1); // Count inversions
            }
        }
        
        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // Copy remaining elements from the right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy merged elements back to the original array
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
        
        return cnt;
    }

}