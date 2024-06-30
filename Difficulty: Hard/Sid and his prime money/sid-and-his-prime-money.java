//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

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
            
            Solution obj = new Solution();
            pair product = obj.primeMoney(a, n);  
            System.out.println(product.second+" "+product.first);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


/*
 class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} */

class Solution {
    
    static pair primeMoney(long arr[], long n)
    {
        // Your code goes here
        
        long cities = 0, max_prime_sum = 0;
        
        long old_count = 1, old_prime_sum = 0;
        long new_count = 1, new_prime_sum = 0;
        
        if(isPrime(arr[0])){
            old_prime_sum = arr[0];
            new_prime_sum = arr[0];
        }
        
        
        for(long i=1; i<n; i++){
            if(arr[(int)(i)] > arr[(int)(i-1)]){
                new_count++;
                if(isPrime(arr[(int)(i)])){
                     new_prime_sum += arr[(int)(i)];
                 }
            }
            else{
                if(new_count > old_count){
                    old_prime_sum = new_prime_sum;
                    old_count = new_count;
                }
                else if(new_count == old_count){
                    old_prime_sum = (new_prime_sum > old_prime_sum) ? new_prime_sum : old_prime_sum;
                }
                
                new_count = 1;
                if(isPrime(arr[(int)(i)])){
                     new_prime_sum = arr[(int)(i)];
                 }
                 else{
                     new_prime_sum = 0;
                 }
            }
        }
        
        if(new_count > old_count){
            old_prime_sum = new_prime_sum;
            old_count = new_count;
        }
        else if(new_count == old_count){
            old_prime_sum = (new_prime_sum > old_prime_sum) ? new_prime_sum : old_prime_sum;
        }
        
        cities = old_count;
        max_prime_sum = old_prime_sum;
        
        
        return new pair(max_prime_sum, cities);
    }
    
    public static boolean isPrime(long num){
        if(num <= 1){
            return false;
        }
        
        if(num == 2){
            return true;
        }
        
        long root = (long)(Math.sqrt(num));
        
        for(long i=2; i<=root; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}