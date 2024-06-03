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
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            int ans=ob.fibonacciDigits(N);
            if(ans/10>0)
             System.out.println(ans);
            else
             System.out.println("0"+ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int fibonacciDigits(long N){
        int fib[]=new int[300];
        fib[0]=0;
        fib[1]=1;
        fib[2]=1;
        for(int i=3;i<300;i++){
            fib[i]= (fib[i-1]+fib[i-2])%100;
        }
        return fib[(int)Math.abs(N%300)];
    }
}