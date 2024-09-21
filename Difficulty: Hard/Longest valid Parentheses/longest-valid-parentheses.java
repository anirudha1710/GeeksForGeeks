//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        if (S == null) {
            throw new NullPointerException("S is null");
        }

        List<Integer> stack = new ArrayList<>();
        int runningLength = 0;
        int maxLength = 0;
        for (int index = 0; index < S.length(); index += 1) {
            char ch = S.charAt(index);
            if (ch == '(') {
                stack.add(runningLength);
                runningLength = 0;
            } else {
                if (stack.size() == 0) {
                    runningLength = 0;
                    continue;
                }

                runningLength += 2 + stack.remove(stack.size() - 1);
                maxLength = Math.max(maxLength, runningLength);
            }
        }

        return maxLength;
    }
}