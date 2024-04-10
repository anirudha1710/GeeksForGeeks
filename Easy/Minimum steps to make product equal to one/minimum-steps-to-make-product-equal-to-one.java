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
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int makeProductOne(int[] arr, int N) {
        // your code here
        int count_neg =0;
        int count_pos =0;
        int count_zero=0;
        
        int op=0;
        
        for(int i=0; i<N; i++)
        {
            int num = arr[i];
            if(num<0)
            {
                count_neg ++;
                int diff = -1 - num;
                op+= diff;
            }
            else if(num>0)
            {
                count_pos++;
                int diff = num-1;
                op+= diff;
            }
            else
            {
                count_zero++;
                op++;
            }
        }
        
        if(count_neg%2!=0 && count_zero==0)
        {
            op+=2;
        }
        
        return op;

    }
};