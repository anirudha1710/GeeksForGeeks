//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int x1 = Integer.parseInt(S[0]);
            int y1 = Integer.parseInt(S[1]);
            int x2 = Integer.parseInt(S[2]);
            int y2 = Integer.parseInt(S[3]);
            int x3 = Integer.parseInt(S[4]);
            int y3 = Integer.parseInt(S[5]);
            int x4 = Integer.parseInt(S[6]);
            int y4 = Integer.parseInt(S[7]);

            Solution ob = new Solution();
            System.out.println(ob.isSquare(x1,y1,x2,y2,x3,y3,x4,y4));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // code here
        int a[]=new int [4];
    int ans=0;
   a[0]=ans=(int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
   a[1]=ans=(int)Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
   a[2]=ans=(int)Math.sqrt((x3-x4)*(x3-x4)+(y3-y4)*(y3-y4));
   a[3]=ans=(int)Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
    
   
    if(a[0]==a[2] && a[1]==a[3] && a[0]!=0 && a[1]!=0){
        return "Yes";
    }
    return "No";
    }
};