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
            
            int d = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int y = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.getDayOfWeek(d,m,y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String getDayOfWeek(int d, int m, int y) {
        // code here
        String days[] = { "Saturday", "Sunday",    "Monday",   "Tuesday",

                         "Wednesday", "Thursday", "Friday" };

                         

        if(m<3){

            m+=12;

            y-=1;

        }

        

        int k=y%100;

        int j=y/100;

        int day=((d+(((m+1)*26)/10)+k+(k/4)+(j/4))+(5*j))%7;

        

        return days[day];
    }
};