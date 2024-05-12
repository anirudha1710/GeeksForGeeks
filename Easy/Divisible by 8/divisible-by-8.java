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
            String s = read.readLine().trim();
            Solution ob = new Solution();
            if(ob.isDivisible8(s) == 1)
            System.out.println("Divisible");
            else
            System.out.println("Not Divisible");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int isDivisible8(String S){
        // code here
        
        if(S.length()<3)
        {
            if(Integer.valueOf(S)%8==0)
            return 1;
            
            S = new String(new StringBuilder(S).reverse());
            
            if(Integer.valueOf(S)%8 ==0)
            return 1;
            
            return 0;
            
        }
        
        int [] arr = new int[10];
        for( int i =0; i<S.length(); i++)
        {
            arr[S.charAt(i)-'0']++;
        }
        
        for(int i= 104; i<1000; i= i+8)
        {
            int val =i;
            int temp[] = new int[10];
            temp[val%10]++;
            val =val/10;
            temp[val%10]++;
            val =val/10;
            temp[val%10]++;
            
            val =i;
            if(temp[val%10]>arr[val%10])
            continue;
            val = val/10;
            
            if(temp[val%10]>arr[val%10])
            continue;
            val = val/10;
            
            if(temp[val%10]>arr[val%10])
            continue;
            
            return 1;
        }
        return 0;
    }
}