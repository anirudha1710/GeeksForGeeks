//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String N = sc.next ();

            if (new Sol().balancedNumber (N))
    		    System.out.println (1);
    		else
    		    System.out.println (0);
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    Boolean balancedNumber(String N)
    {
        // your code here     
        int sum1=0;
        int sum2=0;
        char[]ch=N.toCharArray();
        int n=ch.length;
        int p=ch.length/2;
        
        for(int i=0;i<p;i++){
            for(int j=n-1;j>p;j--){
                sum1+=ch[i];
                sum2+=ch[j];
            }
        }
        if(sum1==sum2){
            return true;
        }
        return false;
    }
}