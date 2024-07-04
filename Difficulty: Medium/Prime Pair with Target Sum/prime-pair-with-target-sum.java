//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        
        int j = n;
        for(int i = 2; i <= n; i++)
        {
            if(isPrime(i))
            {
                lhs.add(i);
                if(lhs.contains(n-i) && i != n-i)
                {
                    list.add(n-i);
                    list.add(i);
                    return list;
                }
            }
            if(isPrime(j))
            {
                lhs.add(j);
                if(lhs.contains(n-j) && j != n-j)
                {
                    list.add(n-j);
                    list.add(j);
                    return list;
                }
            }
            j--;
        }
        
        if(n % 2 == 0)
        {
            if(lhs.contains(n/2))
            {
                list.add(n/2);
                list.add(n/2);
                return list;
            }
        }
        
        list.add(-1);
        list.add(-1);
        
        return list;
    }
    public static boolean isPrime(int n)
    {
        if(n == 3 || n == 2)
        {
            return true;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
