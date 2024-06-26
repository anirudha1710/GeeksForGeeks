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
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
   public String  fractionToDecimal(int numerator, int denominator)
   {
       // code here
       StringBuilder res = new StringBuilder();
       StringBuilder temp = new StringBuilder();
       
       int x = numerator%denominator;
       
       int y = numerator/denominator;
       
       res.append(Integer.toString(y));
       if(x==0) return res.toString();
       
       res.append(".");
       
       HashMap<Integer,Integer> cur = new HashMap<>();
       
       cur.put(x,0);
       x=x*10;
       int i=1;
       
       while(x>0){
           int d = x/denominator;
           int r = x%denominator;
           
           temp.append(d);
           
           if(cur.containsKey(r)){
               int pos = cur.get(r);
               temp.insert(pos,"(");
               temp.append(")");
               break;
           }
           else{
               cur.put(r,i);
               x = r*10;
               i++;
           }
       }
       
       
       return res.append(temp.toString()).toString();
       
       
   }
}