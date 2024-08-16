//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
         Vector<Integer> ans = new Vector<>();

        // Check if all digits are 9
        boolean allNines = true;
        for (int i = 0; i < n; i++) {
            if (num[i] != 9) {
                allNines = false;
                break;
            }
        }

        if (allNines) {
            ans.add(1);
            for (int i = 1; i < n; i++) {
                ans.add(0);
            }
            ans.add(1);
        } else {
            // Solve to generate the next palindrome
            int mid = n / 2;
            int i = mid - 1;
            int j = (n % 2 == 0) ? mid : mid + 1;
            boolean leftSmaller = false;

            // Find if left side is smaller
            while (i >= 0 && num[i] == num[j]) {
                i--;
                j++;
            }

            if (i < 0 || num[i] < num[j]) {
                leftSmaller = true;
            }

            // Mirror the left to right
            i = mid - 1;
            j = (n % 2 == 0) ? mid : mid + 1;
            while (i >= 0) {
                num[j++] = num[i--];
            }

            // Handle the case where left part is smaller
            if (leftSmaller) {
                int carry = 1;
                if (n % 2 == 1) {
                    num[mid] += 1;
                    carry = num[mid] / 10;
                    num[mid] %= 10;
                }

                i = mid - 1;
                j = (n % 2 == 0) ? mid : mid + 1;
                while (i >= 0) {
                    num[i] += carry;
                    carry = num[i] / 10;
                    num[i] %= 10;
                    num[j] = num[i];
                    i--;
                    j++;
                }
            }

            // Convert array to Vector
            for (int k = 0; k < n; k++) {
                ans.add(num[k]);
            }
        }
        return ans;
    }
}