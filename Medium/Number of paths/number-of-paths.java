//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    // code here
    
    static final long MOD = 1000000007;

    long power(long x, long y) {
        long res = 1;
        x = x % MOD;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % MOD;

            y = y / 2;
            x = (x * x) % MOD;
        }
        return res;
    }

    long modInverse(long n) {
        return power(n, MOD - 2);
    }

    long numberOfPaths(int M, int N) {
        long ans = 1;
        for (int i = N; i < M + N - 1; i++) {
            ans = (ans * i) % MOD;
            ans = (ans * modInverse(i - N + 1)) % MOD;
        }
        return ans;
    }
    
}