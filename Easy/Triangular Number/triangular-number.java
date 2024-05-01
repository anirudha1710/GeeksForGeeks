//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N=Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isTriangular(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isTriangular(int N){
        //code here
        int sum = 0;
        if(N<=1)
        {
            return 1;
        }
        for(int i = 1; i<=N; i++)
        {
            sum = sum+i;
            if(sum == N)
            {
                return 1;
            }
        }
        return 0;
    }
}