//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            long L = Long.parseLong(input_line[1]); 
            long R = Long.parseLong(input_line[2]); 
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, L, R); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countSubarray(int N,int A[],long L,long R) {
        // code here
        return countSubArraysLessThanEqualToL(N, A, R) - 
            countSubArraysLessThanEqualToL(N, A, L-1);
    }
    
    private long countSubArraysLessThanEqualToL(int N,int A[],long L) {
        long count = 0, sum = 0;
        int l = 0, r = -1;
        
        while (l < N) {
            while (r+1 < N && sum+A[r+1] <= L) {
                sum += A[r+1];
                r++;
                count += (r-l+1);
            }
            
            if (r+1 == N)
                break;
            
            if (l <= r) {
                sum -= A[l];
                l++;
            } else {
                l++;
                r++;
            }
        }
        return count;
    }
} 