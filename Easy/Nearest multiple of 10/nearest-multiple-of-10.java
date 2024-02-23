//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


            

class Solution{
    
  
    String roundToNearest(String N)
    {
        // Complete the function
        int rem = N.charAt(N.length()-1)-'0';
        if(rem>5)rem = 10-rem;
        else rem*=-1;
        
        return add(N, rem);
    }
    
    private static  String add(String s , int rem){
        int n=s.length();
        int sum=0;

        StringBuilder ans = new StringBuilder();
        for(int i=n-1;i>=0;i--){
           rem+=  (s.charAt(i) - '0');
           ans.insert(0,rem % 10);
           rem /=10;
        }
        
        if(rem!=0)
           ans.insert(0,rem);
    

        
        return ans.toString();
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine().trim();
		    
		    Solution obj = new Solution();
		    
		    String res = obj.roundToNearest(line1);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


// } Driver Code Ends