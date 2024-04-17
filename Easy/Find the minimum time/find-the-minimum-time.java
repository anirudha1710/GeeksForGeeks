//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int S1 = Integer.parseInt(arr[0]);
            int S2 = Integer.parseInt(arr[1]);
            int N = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(S1, S2, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minTime(int s, int t, int n)
    {
        // code here
        int e = Math.min(s, t);
        int ne = Math.max(s, t);
        int min = ne * n;
        int l = 0;
        int r = n;
        while(l <= r) {
            int mid = l + (r-l)/ 2;
            min = Math.min(min, Math.max(e * mid, ne * (n-mid)));
            if( e * mid <= ne * (n-mid) ) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return min;
    }
}