//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        //code here
        if(s.length() < 3 && Integer.parseInt(s)%8 ==0){
            return 1;
        }
        
        String lastThreeDigits = s.substring(s.length()-3);
        
        if( Integer.parseInt(lastThreeDigits) % 8 == 0 ) return 1;
        return -1;
    }
}