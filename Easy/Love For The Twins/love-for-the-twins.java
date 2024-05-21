//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i=0 ; i<N ; i++)
                Arr[i]=Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.getTwinCount(N,Arr));
        }
    }
}
// } Driver Code Ends

//User function Template for Java

class Solution {
    static int getTwinCount(int N , int[] Arr) {
        // code here
        int[] hash = new int[100000];
        int c = 0;
        for(int i = 0; i < N; i++) {
            hash[Arr[i]] ++;
        }
        for(int i = 0; i < N; i++) {
            if(hash[Arr[i]] > 1) {
                if(hash[Arr[i]] % 2 == 0) {
                    c += hash[Arr[i]];
                } else {
                    c += hash[Arr[i]] - 1;
                }
                hash[Arr[i]] = 0;
            }
        }
        return c;
    }
};