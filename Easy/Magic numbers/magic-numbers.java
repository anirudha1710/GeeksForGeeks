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
            int N = Integer.parseInt(read.readLine());
            
            int[] A = new int[N];
            String S[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.getVal(N,A));
        }
    }
}
// } Driver Code Ends

class Solution {
    static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    static Long getVal(int N, int[] A) {
        // code here
        long x=1;
        long l=A[0];
        
        for(int i :A){
            l=gcd(l,i);
            x=x*i;
            x=x%1000000007;
        }
        
        long ans=(long)Math.pow(x,l);
        return ans;
        
        
       
        
    }
};