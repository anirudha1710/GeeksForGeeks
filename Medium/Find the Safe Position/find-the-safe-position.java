//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int safePos(int n, int k) {
        // code here
        k--;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            l.add(i);
        }
        int curr = 0;
        solve(curr, k, l);
        return l.get(0);
    }
    static void solve(int curr, int k, ArrayList<Integer> l){
        if(l.size() == 1){
            return;
        }
        curr = (curr + k) % l.size();
        l.remove(curr);
        solve(curr, k, l);
    }
};