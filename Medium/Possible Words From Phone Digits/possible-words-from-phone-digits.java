//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Code here 
    static void solve(int[] a, int N, HashMap<Integer, String> mp, ArrayList<String> ans, String temp, int ind) {
        if (temp.length() == N) {
            ans.add(temp);
            return;
        }
        for (int i = 0; i < mp.get(a[ind]).length(); i++) {
            String temp1 = temp + mp.get(a[ind]).charAt(i);
            solve(a, N, mp, ans, temp1, ind + 1);
        }
    }

    static ArrayList<String> possibleWords(int[] a, int N) {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "");
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");

        ArrayList<String> ans = new ArrayList<>();
        solve(a, N, mp, ans, "", 0);
        return ans;
    }
}

