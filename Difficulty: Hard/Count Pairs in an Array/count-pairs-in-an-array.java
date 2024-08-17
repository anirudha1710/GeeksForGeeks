//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static int countPairs(int arr[], int n) 
    {
         // Your code goes here
        long[] transformed = new long[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = (long) i * arr[i];
        }

        long[] temp = new long[n];
        return (int) mergeSortAndCount(transformed, 0, n - 1, temp);
    }

    static long mergeSortAndCount(long[] arr, int left, int right, long[] temp) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, left, mid, temp);
            count += mergeSortAndCount(arr, mid + 1, right, temp);
            count += mergeAndCount(arr, left, mid, right, temp);
        }
        return count;
    }

    static long mergeAndCount(long[] arr, int left, int mid, int right, long[] temp) {
        int i = left, j = mid + 1, k = left;
        long inversions = 0;

        System.arraycopy(arr, left, temp, left, right - left + 1);

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                inversions += (mid + 1 - i); 
            }
        }

      
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= right) {
            arr[k++] = temp[j++];
        }

        return inversions;
    }
}
