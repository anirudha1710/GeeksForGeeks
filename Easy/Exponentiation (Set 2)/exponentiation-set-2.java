//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            long b = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.power(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long power(int a, long b){
        //complete the function here
        if(b== 0) return 1; 
        
        long div=  1000000007 ; 
 
        long ans =  power (a , b /2 ) ; 
        ans = (ans) * (ans) % div; 
        
        if(b % 2!= 0 ) 
        ans =a * ans; 
        
        return  ans % div; 
    }
}