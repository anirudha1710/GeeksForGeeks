//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int modulo(int n,String b)
    {
        //code here
        int res=0;
        for(int i=0;i<b.length();i++)
        {
            res=((res*10)+(b.charAt(i)-'0'))%n;
        }
        return res;
    }
    static int getLastDigit(String a, String b) {
        // code here
       int n[]={0,1,4,4,2,1,1,4,4,2};
       int c= Character.getNumericValue(a.charAt(a.length() - 1));
       if(b.equals("0")){
           return 1;
       }
       if(a.equals("0")){
           return 0;
       }
       int mod=modulo(n[c],b);
       if(mod==0){
           if(c==5)
            return 5;
           else if(c==2 ||c==4 ||c==6 || c==8){
               return 6;
           }
       }
       double l=Math.pow(c,mod);
       return (int)l%10;
    }
};