//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int sumOfMax(List<Integer> arr) {
        // code here
        int ans=0;
        for(int i=0;i<arr.size();i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<arr.size();j++){
                 max=Math.max(max,arr.get(j));
                ans+=max;
            }
        }
        
        return ans;
    }
}

//{ Driver Code Starts.

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            List<Integer> arr = new ArrayList<Integer>();

            for (int i = 0; i < str.length; i++) {
                arr.add(Integer.parseInt(str[i]));
            }
            int ans = new Solution().sumOfMax(arr);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends