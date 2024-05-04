//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N =Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenFibSum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long evenFibSum(long N){
        // code here
          long a=1;
       long b=1;
       long c=1;
       long sum=0;
       long mod=1000000007;
       while(c<=N){
           c=(a+b)%mod;
       
           if(N>=c && c%2==0){
               sum+=c;
           }
           a=b;
           b=c;
       }
       return sum;
    } 
};