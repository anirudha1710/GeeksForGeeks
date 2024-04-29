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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int l = Integer.parseInt(input[0]); 
            int r = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l,r));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int sumOfAll(int l, int r)
    {
        // code here
        int[] arr=new int[r+1];
        for(int i=2;i<=r;i++){
            if(arr[i]==0){
                for(int j=i;j<=r;j+=i){
                    arr[j]+=i;
                }
            }
        }
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=arr[i];
        }
        return sum;
    }
}