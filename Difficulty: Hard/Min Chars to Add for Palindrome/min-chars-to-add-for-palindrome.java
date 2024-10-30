//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static int minChar(String s) {
        // Write your code here

        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        sb.reverse().append("%").append(rev);
        String str = sb.toString();

        int[] lps = new int[str.length()];
        int ind = 0;

        int i = 1 ;
        while (i < str.length()) {
            if ( str.charAt(i) == str.charAt(ind) ) {
                ind++;
                lps[i] = ind ;
                i++;
            }
            else {
                if (ind==0) {
                    lps[i]=0;
                    i++;
                }
                else {
                    ind = lps[ind-1];
                }
            }
        }
        return s.length() - lps[str.length()-1];
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends