//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.minMoves(a, n));
            
        }
	}
}


// } Driver Code Ends





//User function Template for Java


class Compute {
    
    public long minMoves(long arr[], long n)
    {
        // code here
        long count=0,temp=0;
        boolean isOne=true;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                if(isOne){
                    isOne=false;
                    count=Math.max(count,temp);
                    temp=0;
                }else{
                    count=Math.max(count,(temp+1)/2);
                    temp=0;
                }
            }else{
                temp++;
            }
        }
        if(isOne) return -1;
        count=Math.max(count,temp);
        
        return count;
        
    }
}