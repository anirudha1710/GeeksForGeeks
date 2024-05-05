//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPallindrome(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long isPallindrome(long N){
        // code here
        int c=0,k;
        StringBuilder rev=new StringBuilder();
        Stack<Long> st=new Stack<>();
        String a;
     long dig;
        while(N>0)
        {
            dig=N%2;
            st.push(dig);
            N=N/2;
        }
        while(!st.isEmpty())
        {
            rev.append(st.pop());
        }
        a=rev.toString();
        k=a.length();
        int i;
        for(i=0;i<=k/2;i++)
        {
            if(a.charAt(i)==a.charAt(k-1-i))
            continue;
            else
            {
                c=1;
                break;
            }
        }
        if(c==1)
        return 0;
        else
        return 1;
    }
}