//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        
        for (int i = 0; i < n; ++i) {
            if (gallery[i] == 0) {
                arr[i] = Math.max(arr[i], i);
                continue;
            }
            if (gallery[i] != -1) {
                int k = i + gallery[i];
                int j = Math.max(0, i - gallery[i]);
                for (int sprink = j; sprink <= Math.min(n - 1, k); ++sprink)
                    arr[sprink] = Math.max(k, arr[sprink]);
            }
        }
        
        int count = 0, i = 0;
        while (i < n) {
            if (i == -1 || arr[i] == -1)
                return -1;
            ++count;
            i = arr[i] + 1;
        }
        return count;
    }
}
