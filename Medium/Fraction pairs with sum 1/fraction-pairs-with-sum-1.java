//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // your code here
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        for(int i = 0; i < n; i++){
            int gcd = gcd(numerator[i], denominator[i]);
            int num = numerator[i]/gcd;
            int den = denominator[i]/gcd;
            if(num >= den) continue;
            String key = (den-num)+"/"+den;
            if(map.get(key) != null) count+= map.get(key);
            key = num+"/"+den;
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        return count;
    }
    private static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}
        
