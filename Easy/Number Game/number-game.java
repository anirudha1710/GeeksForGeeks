//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long n = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numGame(n));
        }
    }
}
// } Driver Code Ends

    
class Solution {
    static Long numGame(Long n) {
        // code here
        long result = 1;
        for(long i = 2; i <= n; i++) {
            result = lcm(i, result);
        }
        return result;
    }
    
    private static long lcm(long a, long b) {
        return ((a * b)/gcd(a, b)) % 1000000007;
    }
    
    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
};