//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  Solution ob = new Solution();
		  System.out.println(ob.primeDigits(n));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find nth number made of only prime digits.
    public static int primeDigits(int n)
    {
        //Your code here
        if (n == 1) 
            return 2;

        int count = 1;
        int num = 2;
        HashSet<Integer> primeDigitsSet = new HashSet<>();
        primeDigitsSet.add(2);
        primeDigitsSet.add(3);
        primeDigitsSet.add(5);
        primeDigitsSet.add(7);

        while (count < n) 
        {
            num++;
            int temp = num;
            boolean isPrimeDigit = true;
            while (temp > 0)
            {
                int lastDigit = temp % 10;
                temp /= 10;
                if (!primeDigitsSet.contains(lastDigit)) 
                {
                    isPrimeDigit = false;
                    break;
                }
            }

            if (isPrimeDigit) 
                count++;
            
        }

        return num;
    }
}