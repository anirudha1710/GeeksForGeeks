//{ Driver Code Starts
//Initial Template for Java


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
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            long a = Long.parseLong(S1[0]);
            long b = Long.parseLong(S1[1]);
            long c = Long.parseLong(S1[2]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            int n = Integer.parseInt(S2[0]);
            String s3 = br.readLine().trim();
            String []S3 = s3.split(" ");
            long [] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = Long.parseLong(S3[i]);
            }
            Solution ob = new Solution();
            long [] ans = ob.sortArray(arr, n, a, b, c);
            for(int i = 0; i < n; i++){
                System.out.print(ans[i]);
                System.out.print(" ");
            }
            System.out.println();          
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long[] sortArray(long []arr, int n, long A, long B, long C)
    {
        // Code here
        for (int i = 0; i < n; i++) 
        arr[i] = A*arr[i]*arr[i] + B*arr[i] + C; 
        int f = 1;
        if(A > 0) f = 2;
        int i = 0, j = n-1; 
        long new_arr[]=new long[n]; 
        int k = 0; 
        if(f==1){
            while (i <=j){
                if (arr[i] < arr[j])
                    new_arr[k++] = arr[i++];
                else
                    new_arr[k++] = arr[j--];
            }
        }else{
            while (i <=j){
                if (arr[i] > arr[j])
                    new_arr[k++] = arr[i++];
                else
                    new_arr[k++] = arr[j--];
            }
        } 
        
        for(i = 0; i < n; i++)
            arr[i] = new_arr[i];
    
        if(f == 2){
            for(i = 0; i < n / 2; i++){
                long temp=arr[i];
                arr[i]=arr[n-i-1];
                arr[n-i-1]=temp;
            }
        }
    
        return arr;
    }
}