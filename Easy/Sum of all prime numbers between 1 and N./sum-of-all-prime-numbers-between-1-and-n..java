//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.prime_Sum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public long prime_Sum(int n)
    {
        // code here
        long result = 0;
        int arr[] = new int[n+1];
        arr[0] = 1; 
        arr[1] = 1;
        for(int i=2; i<= (n); i++) {
            if(arr[i] == 0) {
                result +=  i;
                for (long j = (long)i * i; j <= n; j += i) {
                    arr[(int)j] = 1;
                }
            }
        }
        return result;
    }
}