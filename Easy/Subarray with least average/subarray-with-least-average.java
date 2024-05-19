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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String s1 = br.readLine().trim();
            String[] S1 = s.split(" ");
            String[] S2 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            int ans = ob.least_average(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int least_average(int[] nums, int k)
    {
        // code here
       int  sum=0;
       int n=nums.length;
       if(k>n)
       {
           return -1;
       }
       for(int i=0;i<k;i++)
       {
           sum+=nums[i];
       }
        
        int min=sum,begin=0;
        for(int i=0;i<n-k;i++)
        {
            sum=sum-nums[i]+nums[i+k];
            if(sum<min)
            {
                min=sum;  
                begin=i+1;
            }
        }
        
        
        return begin+1;
    }
}