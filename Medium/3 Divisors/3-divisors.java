//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        
        ArrayList<Integer> list = new ArrayList<Integer>(q);
        int count;
        for(int i=0; i<query.size(); i++) {
            count = 0;
            for(int j=2; j*j <= query.get(i); j++) {
                if(hasThreeDivisors(j) && j*j <= query.get(i)) count++;
            }
            list.add(count);
        }
        return list;
    }
    
    static boolean hasThreeDivisors(int n) {
        
        boolean res = true;
        for(int i=2; i*i <= n; i++) {
            if(n%i == 0) {
                res = false;
            }
        }
        return res;
    }
}