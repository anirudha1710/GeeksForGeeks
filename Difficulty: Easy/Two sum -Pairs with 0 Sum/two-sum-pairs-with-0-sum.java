//{ Driver Code Starts
import java.io.*;
import java.util.*;

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

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.getPairs(arr);
            if (res.size() == 0) {
                System.out.println();
            } else {
                IntMatrix.print(res);
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        int countZero = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i: arr){
            hs.add(i);
            if(i == 0)
                countZero++;
        }
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        for(int i: arr){
            ArrayList<Integer> li = new ArrayList<>();
            if(i == 0){
                if(hs.contains(0) && countZero >= 2){
                li.add(0); li.add(0); al.add(li);   
                hs.remove(0);
                }
            } else {
                if(hs.contains(-i)){
                    int x = i>0 ? -i : i;
                    li.add(x); li.add(-x); al.add(li);
                    hs.remove(i); hs.remove(-i);
                }
            }
        }
        
        al.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        return al;
    }
}
