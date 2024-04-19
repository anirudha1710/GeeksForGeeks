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
            int n = Integer.parseInt(read.readLine());
            int[] A = new int[n];
            String S[] = read.readLine().split(" ");
            for(int i=0; i<n; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.rightmostNonZeroDigit(n, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int rightmostNonZeroDigit(int N, int[] A){
        // code here
        int count=0, ans=1;
        
        for (int i=0; i < N; i++)
        {
            while (A[i] > 0 && (A[i] % 5) == 0)
            {
                A[i] /= 5;
                count++;
            }
        }
        
        for (int i=0; i < N; i++)
        {
            while (count > 0 && A[i] > 0 && (A[i]&1)==0)
            {
                A[i] >>= 1;
                count--;
            }
        }
        
        for (int i=0; i < N; i++)
            ans = (ans * (A[i]%10)) % 10;
            
        if (count != 0)
            ans = (ans*5)%10;
        if (ans != 0)
            return ans;
        
        return -1;
    }
}