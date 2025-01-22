//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return binarySearch(nums2, nums1); 
        }
        return binarySearch(nums1, nums2);
    }

    private double binarySearch(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int k = (n + 1) / 2;

        int low = 0;
        if(k > n2) {
            // If k is greater than n2 then we can to pick atleast (k - n2) elements from arr1
            low = k - n2;
        }

        int high = n1;
        if(k < n1) {
            // If k is less than n1 then we can to pick atmost k elements from arr1
            high = k;
        }

        while(low <= high) {

            int partition1 = low + (high - low) / 2;
            int partition2 = k - partition1;

            int l1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int l2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int r1 = partition1 == n1 ? Integer.MAX_VALUE : arr1[partition1];
            int r2 = partition2 == n2 ? Integer.MAX_VALUE : arr2[partition2];

            if(l1 <= r2 && l2 <= r1) {
                if((n & 1) == 1) {
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if(l1 > r2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return -1;
    }
}